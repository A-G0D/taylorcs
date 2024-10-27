import sys
sys.stdin = open("dryrun.in", "r")

n = int(input())
for i in range(n):
    print("Movie: " + input())