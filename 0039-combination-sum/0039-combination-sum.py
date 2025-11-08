class Solution(object):
    def combinationSum(self, can, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        res=[]
        def backtrace(st, com, curr):
            if curr==target:
                res.append(list(com))
                return
            if curr>target:
                return
            for i in range(st, len(can)):
                com.append(can[i])
                backtrace(i, com, curr+can[i])
                com.pop()
        backtrace(0, [], 0)
        return res