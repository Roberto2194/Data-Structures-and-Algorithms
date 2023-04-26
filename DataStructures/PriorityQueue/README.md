# Priority Queue

A <b>Priority Queue</b> is a type of queue that arranges elements based on their priority values. Elements with higher priority values are typically retrieved before elements with lower priority values.

The priority queue can be implemented in four ways that include: 

- arrays 
- linked list 
- binary heap 
- binary search tree

The binary heap data structure is considered to be the most efficient way of implementing the priority queue.

<b>Definition:</b> A binary tree is <em>heap-ordered</em> if the key in each node is larger than or equal to the keys in that node's two children (if any).
Therefore, we can say that there are two types of heaps:

<b>Definition:</b> A <em>binary heap</em> is a collection of keys arranged in a complete heap-ordered binary tree, represented in level order in an array (not using the first entry).

- **Max heap**: The max heap is a heap in which the value of the parent node is greater than the value of the child nodes.

- **Min heap**: The min heap is a heap in which the value of the parent node is less than the value of the child nodes.

![Queue-Data-Structure](https://user-images.githubusercontent.com/57627290/234299529-d0c5505c-7651-45d1-8e5a-1bd3390bdeba.png)

## Basic Operations:

- **insert()** insert a key into the priority queue.
- **max()** or **min()** returns (but does not remove) the largest (or smallest) key.
- **delMax()** or **delMin()** returns and removes the largest (or smallest) key.
- **size()** number of key in the priority queue.
- **isEmpty()** returns true if the priority queue is empty, else false.
