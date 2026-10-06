#!/usr/bin/env python3
"""
Script to update LeetCode README solved dates based on commit history.
This script analyzes Git commits and updates the README.md table with accurate solve dates.
"""

import subprocess
import re
from datetime import datetime
from pathlib import Path

def get_commit_history():
    """Get all commits with their dates and changed files."""
    try:
        result = subprocess.run(
            ['git', 'log', '--pretty=format:%H%n%aI%n%s', '--name-only'],
            cwd='.',
            capture_output=True,
            text=True
        )
        
        commits = {}
        lines = result.stdout.strip().split('\n')
        
        i = 0
        while i < len(lines):
            if i + 2 < len(lines):
                commit_hash = lines[i]
                commit_date = lines[i + 1]
                commit_msg = lines[i + 2]
                
                # Parse the ISO date to YYYY-MM-DD format
                try:
                    dt = datetime.fromisoformat(commit_date.replace('Z', '+00:00'))
                    date_str = dt.strftime('%Y-%m-%d')
                except:
                    date_str = commit_date
                
                # Get the changed files (skip empty lines)
                files = []
                j = i + 3
                while j < len(lines) and lines[j].strip() and not lines[j].startswith('commit'):
                    if lines[j].strip():
                        files.append(lines[j].strip())
                    j += 1
                
                if files:
                    commits[commit_hash] = {
                        'date': date_str,
                        'message': commit_msg,
                        'files': files
                    }
                
                i = j
            else:
                i += 1
        
        return commits
    except Exception as e:
        print(f"Error getting commit history: {e}")
        return {}

def extract_problem_id_from_file(filepath):
    """Extract problem number from file path."""
    # Match patterns like "123-problem-name/Solution.java" or "123-problem-name/"
    match = re.match(r'^(\d+)-', filepath)
    if match:
        return match.group(1)
    return None

def map_commits_to_problems(commits):
    """Map commits to problem IDs based on modified files."""
    problem_dates = {}
    
    for commit_hash, commit_info in commits.items():
        for filepath in commit_info['files']:
            problem_id = extract_problem_id_from_file(filepath)
            if problem_id:
                # Keep the earliest date for each problem (first solve)
                if problem_id not in problem_dates:
                    problem_dates[problem_id] = commit_info['date']
                else:
                    # Keep the earlier date
                    if commit_info['date'] < problem_dates[problem_id]:
                        problem_dates[problem_id] = commit_info['date']
    
    return problem_dates

def update_readme(problem_dates):
    """Update README.md with correct solve dates."""
    readme_path = Path('README.md')
    
    if not readme_path.exists():
        print("README.md not found!")
        return False
    
    with open(readme_path, 'r', encoding='utf-8') as f:
        content = f.read()
    
    # Replace dates in the table rows
    # Pattern: | NUMBER | [PROBLEM_LINK] | DIFFICULTY | YYYY-MM-DD |
    
    def replace_date(match):
        full_match = match.group(0)
        problem_num = match.group(1)
        
        if problem_num in problem_dates:
            new_date = problem_dates[problem_num]
            # Replace the date at the end of the line
            return re.sub(r'\| \d{4}-\d{2}-\d{2} \|$', f'| {new_date} |', full_match)
        return full_match
    
    # Find and replace dates in table rows
    updated_content = re.sub(
        r'\| (\d+) \| \[([^\]]+)\]\(([^)]+)\) \| (Easy|Medium|Hard) \| \d{4}-\d{2}-\d{2} \|',
        lambda m: f"| {m.group(1)} | [{m.group(2)}]({m.group(3)}) | {m.group(4)} | {problem_dates.get(m.group(1), m.group(0).split('|')[-2].strip())} |",
        content
    )
    
    with open(readme_path, 'w', encoding='utf-8') as f:
        f.write(updated_content)
    
    print("README.md updated successfully!")
    return True

if __name__ == '__main__':
    print("Analyzing commit history...")
    commits = get_commit_history()
    print(f"Found {len(commits)} commits")
    
    print("Mapping commits to problems...")
    problem_dates = map_commits_to_problems(commits)
    print(f"Found solve dates for {len(problem_dates)} problems:")
    for problem_id in sorted(problem_dates.keys(), key=lambda x: int(x)):
        print(f"  Problem {problem_id}: {problem_dates[problem_id]}")
    
    print("\nUpdating README.md...")
    update_readme(problem_dates)
