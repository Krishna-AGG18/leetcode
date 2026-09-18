// 104 ms | 8.8 MB
#include <stdlib.h>

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    *returnSize = 2; // We will return two indices
    int* result = (int*)malloc(*returnSize * sizeof(int)); // Allocate memory for result

    // Check if memory allocation was successful
    if (result == NULL) {
        *returnSize = 0; // Set return size to 0 if allocation fails
        return NULL; // Return NULL on failure
    }

    for (int i = 0; i < numsSize; i++) {
        for (int j = i + 1; j < numsSize; j++) { // Start j from i + 1 to avoid duplicates
            if (nums[i] + nums[j] == target) {
                result[0] = i; // Store first index
                result[1] = j; // Store second index
                return result; // Return the result immediately
            }
        }
    }

    free(result); // Free memory if no solution found
    *returnSize = 0; // Set return size to 0 if no solution found
    return NULL; // Return NULL if no solution found
}
