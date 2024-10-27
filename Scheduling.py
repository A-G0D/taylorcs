import sys
sys.stdin = open("Scheduling.in", "r")

n: int = int(input())
w: bool = True
l: list[int] = [330, 270, 270]

for i in range(n):
    s: str
    h: int
    m: int
    s, h, m = input().split()
    m = int(h) * 60 + int(m)
    idx: int = (i+1) % 3
    if (l[idx] > m):
        l[idx] -= m
    else:
        if not any([val > m] for val in l):
            w = False
            break
        else:
            idx = (idx + 1) % 3
            if (l[idx] > m):
                l[idx] -= m
            else:
                idx = (idx + 1) % 3
                if (l[idx] > m):
                    l[idx] -= m

print("YES" if w else "NO")