#The test case that should test:

* borderline cases, such as a list with 0 or 1 elements
* typical cases, such as a list with a few duplicates or no duplicates
* impossible cases where the method should not work
* extreme cases, such as a huge list

## Tests for countUnique

| Test case              |  Expected Result    |
|------------------------|---------------------|
| empty list             |  return 0           |
| one item               |  return 1           |
| one item many times    |  return 1           |
| 2 items, many times, many order | return 2   |
| 4 items with duplicates in various order   | return 4     |
| 3 items with mix type( String, int and double)   | return 3     |
| 10,000 items  | return 10,000     |
| null element item  | return 1     |

## Tests for binarySearch

| Test case              |  Expected Result    |
|------------------------|---------------------|
| empty array             |  return -1           |
| search null              |  return IllegalArgumentException          |
| item is not in array    |  return -1           |
| 1 item    |  return 0           |
| 4 items, sort order | return 2   |
| 4 items, mess sort  | return 2   |
| 5 items, sort order, first element  | return 0   |
| 5 items, sort order, last element  | return 4   |
| 5 items, sort order, middle element  | return 2   |
| 5 items, sort order, other element  | return 3   |
| 10,000 items, sort order, first element  | return 0   |
| 10,000 items, sort order, last element  | return 9,999   |
| 10,000 items, sort order, other element  | return n-1   |
