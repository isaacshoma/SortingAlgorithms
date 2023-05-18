import Foundation

// Create quickSort function
func quickSort(array: inout [Int], low: Int, high: Int) {

    // Check if the low is greater than the high index
    // Get our pivot
    if low <= high {
        let pivotIndex = partition(array: &array, low: low, high: high)

        // Sort the arrays from from the start to the end
        quickSort(array: &array, low: low, high: pivotIndex - 1)
        quickSort(array: &array, low: pivotIndex + 1, high: high)
    }
}

// Create partition function
func partition(array: inout [Int], low: Int, high: Int) -> Int {

    // Choose the designated pivot point
    let pivot = array[high]
    var leftPointer = low - 1

    // Iterate through the loop until low index and high index until they meet
    for rightPointer in low..<high {
        if array[rightPointer] <= pivot {
            leftPointer += 1

            // If the number is less than or equal to the pivot
            // swap the left and right pointer
            array.swapAt(leftPointer, rightPointer)
        }
    }
    // The number is now in the correct spot
    // return index
    array.swapAt(leftPointer + 1, high)
    return leftPointer + 1
}

var array = [Int]()

// Input the desired file path
let filePath = "/Users/isaac/Desktop/item.txt"

do {
    let fileContents = try String(contentsOfFile: filePath, encoding: .utf8)
    let lines = fileContents.components(separatedBy: "\n")

    for line in lines {
        // Process each line here
        let integers = line.components(separatedBy: "\t").compactMap { Int($0) }
        for i in integers {
            array.append(i)
        }
    }
} catch {
    print("Error reading file: \(error)")
}

quickSort(array: &array, low: 0, high: array.count - 1)
print(array)

