// LeetCode 1700 - Number of Students Unable to Eat Lunch
// Difficulty: Easy
// Problem: Find how many students cannot eat due to sandwich preference
// What to do: Simulate sandwich serving until no student wants the top sandwich
// Approach: Count student preferences instead of full simulation
// How it works:
// - Count students who like circular (0) and square (1)
// - Traverse sandwiches from top
// - If preference exists, serve; otherwise stop
// Concept Used: Counting, Greedy
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        int count0 = 0, count1 = 0;

        // Count student preferences
        for (int s : students) {
            if (s == 0) count0++;
            else count1++;
        }

        // Process sandwiches
        for (int sandwich : sandwiches) {
            if (sandwich == 0) {
                if (count0 == 0) break;
                count0--;
            } else {
                if (count1 == 0) break;
                count1--;
            }
        }

        return count0 + count1;
    }
}
