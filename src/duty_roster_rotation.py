
def rotateRoster(names, k):
    n = len(names)
    k = k % n

    result = [None] * n

    for i in range(n):
        new_index = (i + k) % n
        result[new_index] = names[i]

    return result


names = ["A", "B", "C", "D", "E"]

print(rotateRoster(names, 2))
print(rotateRoster(names, 7))
