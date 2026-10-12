
def secondHighest(scores):
    highest = -1
    second = -1

    for score in scores:
        if score > highest:
            second = highest
            highest = score

        elif score < highest and score > second:
            second = score

    return second


scores = [45, 78, 92, 78, 60]
print(secondHighest(scores))

scores = [50, 50, 50]
print(secondHighest(scores))
