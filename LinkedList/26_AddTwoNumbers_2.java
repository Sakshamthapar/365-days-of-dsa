# LeetCode 2 – Add Two Numbers

## 🧩 Problem
You are given two **non-empty linked lists** representing two non-negative integers.  
The digits are stored in **reverse order**, and each node contains a single digit.

Add the two numbers and return the sum as a linked list.

---

## 💡 Approach
We simulate **manual addition** (like adding numbers digit by digit):

- Traverse both linked lists simultaneously
- Add corresponding digits along with a `carry`
- Store the result digit in a new linked list
- Continue until both lists and carry are exhausted

---

## 🛠️ Algorithm
1. Create a dummy node to build the result list
2. Initialize `carry = 0`
3. While `l1`, `l2`, or `carry` exists:
   - Get values from nodes (0 if null)
   - Compute `sum = val1 + val2 + carry`
   - Update `carry = sum / 10`
   - Create a new node with `sum % 10`
4. Return `dummy.next`

---

## ⏱️ Complexity Analysis
- **Time Complexity:** `O(max(n, m))`
- **Space Complexity:** `O(max(n, m))`

Where `n` and `m` are the lengths of the two linked lists.

---
