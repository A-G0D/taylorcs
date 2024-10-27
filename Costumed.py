import sys
sys.stdin = open("Costumed.in", "r")
people: list[tuple] = []
suspects: list[tuple] = []

def match(a: tuple[str, str, str], b: tuple[str, int, str]) -> bool:
    persIsUnderClass: bool = a[0] in ["Skeleton", "Zombie", "Witch"]
    susIsUnderClass: bool = b[1] < 11
    persIsBoy: bool = a[1] == "Pumpkin"
    susIsBoy: bool = b[2] == "Boy"
    persIsTaylor: bool = a[2] in ["Kit-Kats", "Jolly Ranchers", "Hershey Kisses"]
    susIsTaylor: bool = b[0] == "Taylor"
    return (persIsUnderClass == susIsUnderClass) and (persIsBoy == susIsBoy) and (persIsTaylor == susIsTaylor)

np: int = int(input())
for i in range(np):
    lp: list[str] = input().split()
    costume: str = lp[0]
    holding: str = lp[1]
    snack: str = " ".join(lp[2:])
    people.append((costume, holding, snack))

ns: int = int(input())
for i in range(ns):
    ls: list[str] = input().split()
    name: str = ls[0]
    school: str = " ".join(ls[1: -2])
    grade: int = int(ls[-2])
    gender: str = ls[-1]
    suspects.append((school, grade, gender))

for i in range(len(people)):
    try: 
        person: tuple[str, str, str] = people[i]
        matches: bool = False
        for suspect in suspects:
            if match(person, suspect):
                matches = True
                break
        if not matches:
            people.pop(i)
            i -= 1
    except:
        break

print(len(people))