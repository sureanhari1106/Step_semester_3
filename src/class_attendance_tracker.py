
def attendanceSummary(days):
    present = 0
    current_streak = 0
    longest_streak = 0

    for day in days:
        if day == 1:
            present += 1
            current_streak += 1

            if current_streak > longest_streak:
                longest_streak = current_streak
        else:
            current_streak = 0

    return present, longest_streak


days = [1, 1, 0, 1, 1, 1, 0, 1]

present, streak = attendanceSummary(days)

print(f"Present: {present}, Longest streak: {streak}")
