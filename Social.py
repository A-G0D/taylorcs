import sys
sys.stdin = open("Social.in", "r")

n = int(input())
res = 0
for i in range(n):
    s, t, v = input().split()
    v = int(v)
    if t == "Games":
        res += v / 10
    else:
        res -= v / 10
print("Games" if res > 0 else "Boba")