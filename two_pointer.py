#/*We are given two arrays that represent the arrival and departure times of trains, the
#task is to find the minimum number of platforms required so that no train waits.
#Examples:
#Input: arr[] = {9:00, 9:40, 9:50, 11:00, 15:00, 18:00}, dep[] = {9:10, 12:00, 11:20, 11:30,
#19:00, 20:00}
#Output: 3
#Explanation: There are at-most three trains at a time (time between 9:40 to 12:00)

#Input: arr[] = {9:00, 9:40}, dep[] = {9:10, 12:00}
#Output: 1
#Explanation: Only one platform is needed. /





def findMinPlatforms(arr, dep):
    arr.sort()
    dep.sort()
    
    n = len(arr)
    platform_needed = 0
    max_platforms = 0
    i, j = 0, 0

    while i < n and j < n:
        if arr[i] <= dep[j]:  # Train arrives before the last one departs
            platform_needed += 1
            max_platforms = max(max_platforms, platform_needed)
            i += 1
        else:  # Train departs
            platform_needed -= 1
            j += 1

    return max_platforms

# Test case
arr = [900, 940, 950, 1100, 1500, 1800]  # Convert 9:00 to 900, etc.
dep = [910, 1200, 1120, 1130, 1900, 2000]

print(findMinPlatforms(arr, dep))  
# Output: 3
