class Solution(object):
    def longestValidParentheses(self, s):
        stack = [-1]  # Initialize stack with -1 to handle valid substrings starting from index 0
        max_length = 0  # To store the length of the longest valid substring
        
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)  # Push the index of '(' onto the stack
            else:
                stack.pop()  # Pop the index of the last unmatched '('
                
                if len(stack) == 0:
                    stack.append(i)  # Push the current index as a new base for future valid substrings
                else:
                    max_length = max(max_length, i - stack[-1])  # Update max_length
        
        return max_length