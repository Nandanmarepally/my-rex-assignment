#Given a sorted array of positive and negative numbers. You have to Square it and sort it.
#Constraint : Time complexity O(n)
#Example:
#Input: [-12, -8 , -7, -5, 2, 4, 5, 11, 15]
#Output : [4, 16, 25, 25, 49, 56, 121, 144, 225]

def sortedSquares(arr):
    n = len(arr)
    result = [0] * n
    left, right = 0, n - 1
    index = n - 1  # Start filling result from the end

    while left <= right:
        left_sq = arr[left] ** 2
        right_sq = arr[right] ** 2

        if left_sq > right_sq:
            result[index] = left_sq
            left += 1
        else:
            result[index] = right_sq
            right -= 1

        index -= 1

    return result

# Test
arr = [-12, -8, -7, -5, 2, 4, 5, 11, 15]
print(sortedSquares(arr))
