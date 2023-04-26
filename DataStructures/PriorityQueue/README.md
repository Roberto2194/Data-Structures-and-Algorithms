# Priority Queue

A <b>Priority Queue</b> is a type of queue that arranges elements based on their priority values. Elements with higher priority values are typically retrieved before elements with lower priority values.

The priority queue can be implemented in four ways that include: 

- arrays 
- linked list 
- binary heap 
- binary search tree

The binary heap data structure is considered to be the most efficient way of implementing the priority queue.

![different-pq-implementations-complexity](https://user-images.githubusercontent.com/57627290/234576328-3d9d8277-54c9-4d9a-807c-a1890018f0a9.png)

<b>Definition:</b> A binary tree is <em>heap-ordered</em> if the key in each node is larger than or equal to the keys in that node's two children (if any).
Therefore, we can say that there are two types of heaps:

<b>Definition:</b> A <em>binary heap</em> is a collection of keys arranged in a complete heap-ordered binary tree, represented in level order in an array (not using the first entry).

- **Max heap**: The max heap is a heap in which the value of the parent node is greater than the value of the child nodes.

![max-heap](https://user-images.githubusercontent.com/57627290/234576756-de731bb2-0caf-4ec1-8797-94ef878048a9.png)

- **Min heap**: The min heap is a heap in which the value of the parent node is less than the value of the child nodes.

![min-heap](https://user-images.githubusercontent.com/57627290/234576822-12fa6fb7-8847-4e49-ad08-7687225854aa.png)

## Basic Operations:

- **insert()** insert a key into the priority queue.
- **max()** or **min()** returns (but does not remove) the largest (or smallest) key.
- **delMax()** or **delMin()** returns and removes the largest (or smallest) key.
- **size()** number of key in the priority queue.
- **isEmpty()** returns true if the priority queue is empty, else false.
