
def busiestRow(grid):
    max_total = -1
    best_row = 0

    for i in range(len(grid)):
        total = 0

        for j in range(len(grid[i])):
            total += grid[i][j]

        if total > max_total:
            max_total = total
            best_row = i

    return best_row, max_total


grid = [
    [2, 0, 1],
    [3, 3, 1],
    [1, 1, 1]
]

row, total = busiestRow(grid)
print(f"Row {row}, Total {total}")
