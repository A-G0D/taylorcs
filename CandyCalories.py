import sys
sys.stdin = open("CandyCalories.in", "r")

n = int(input())
l = []
for i in range(n):
    s, cnt, val = input().split()
    cnt, val = map(int, [cnt, val])
    l.append((s, cnt, val))
l.sort(key = lambda x: x[2])
cnt = 0
sm = 0
for i in l:
    if sm < 1500 and sm + i[2] < 1500:
        tmp = min(i[1], (1499 - sm) // i[2])
        sm += tmp * i[2]
        cnt += tmp
print(cnt)