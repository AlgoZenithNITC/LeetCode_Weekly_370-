class Solution:
    def findHighAccessEmployees(self, access_times):
        mp = {}
        for it in access_times:
            time = int(it[1])
            if it[0] not in mp:
                mp[it[0]] = []
            mp[it[0]].append(time)
        for key in mp:
            mp[key].sort()
        ans = []
        for key in mp:
            times = mp[key]
            for i in range(2, len(times)):
                if times[i] - times[i - 2] < 100:
                    ans.append(key)
                    break
        return ans


