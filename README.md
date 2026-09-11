# Electronic Inventory Data Structure

## Overview

This project implements a custom sorted-array set in Java for managing an electronic inventory. The collection stores different types of electronic products while maintaining sorted order and preventing duplicate records.

The project demonstrates how a custom data structure can be combined with object-oriented programming concepts to manage and organize inventory data.

## Features

- Custom array-based collection
- Maintains electronic records in sorted order
- Prevents duplicate records
- Supports searching with `indexOf()`
- Supports retrieving records with `grab()`
- Supports removing records with `remove()`
- Filters inventory by electronic category
- Reads inventory data from a text file
- Uses `Comparable` to define record ordering
- Uses inheritance for different electronic types

## Data Structure

### Electronic Sorted Array Set

The `electronicSortedArraySet` class uses a fixed-size array to store electronic records.

The collection:

- Inserts records in sorted order
- Checks for duplicates before insertion
- Shifts elements when inserting or removing records
- Searches for records using `indexOf()`
- Retrieves records using `grab()`
- Removes records using `remove()`
- Creates category-specific collections using `categorySet()`

## Object-Oriented Design

The project uses an inheritance hierarchy based on the `electronic` class.

```text
electronic
├── phone
├── laptop
└── camera
