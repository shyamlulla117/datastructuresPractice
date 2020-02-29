package main.dsa;

public class HeapImplementation {
	public static void main(String[] args) {
		MinHeap heap = new MinHeap(20);
		initHeap(heap);
		heap.printHeap();
		heap.insertInHeap(1);
		heap.printHeap();
		System.out.println(heap.removeFromHeap());
		heap.printHeap();
		System.out.println(heap.removeFromHeap());
		heap.printHeap();
		System.out.println(heap.removeFromHeap());
		heap.printHeap();
		System.out.println(heap.removeFromHeap());
		heap.printHeap();
		System.out.println(heap.removeFromHeap());
		heap.printHeap();
	}
	
	public static void initHeap(MinHeap heap) {
		heap.insertInHeap(10);
		heap.insertInHeap(9);
		heap.insertInHeap(8);
		heap.insertInHeap(7);
		heap.insertInHeap(6);
		heap.insertInHeap(5);
		heap.insertInHeap(4);
		heap.insertInHeap(3);
		heap.insertInHeap(2);
		heap.insertInHeap(1);
	}
}

class MinHeap {
	int[] arr;
	int count;
	int capacity;
	
	public MinHeap(int capacity) {
		count = 0;
		arr = new int[capacity];
		this.capacity = capacity;
	}
	
	public int getLeftChild(int position) {
		if(position >= 0 && position < count) {
			int leftChildPosition = 2*position + 1;
			if(leftChildPosition < count) {
				return arr[leftChildPosition];
			}
		}
		return -1;
	}
	
	public int getRightChild(int position) {
		if(position >= 0 && position < count) {
			int rightChildPosition = 2*position + 2;
			if(rightChildPosition < count) {
				return arr[rightChildPosition];
			}
		}
		return -1;
	}
		
	public int getParent(int position) {
		if(position >= 0 && position < count) {
			int parentPosition = (position-1)/2;
			if(parentPosition >= 0) {
				return arr[parentPosition];
			}
		}
		return -1;
	}
	
	public void insertInHeap(int data) {
		if(count < capacity) {
			arr[count] = data;
			int i = count;
			count++;
			
			while(i>=0 && data < arr[(i-1)/2]) {
				arr[i] = arr[(i-1)/2];
				i = (i-1)/2;
				arr[i] = data;
			}
			
		} else {
			//throw error or increase capacity
		}
	}
	
	public int removeFromHeap() {
		int data = -1;
		if(count > 0) {
			data = arr[0];
			arr[0] = arr[count -1];
			arr[count-1] = 0;
			count--;
			
		}
		percolateDown(0);
		return data;
	}
	
	public void percolateDown(int i) {
		int l,r,min, temp;
		l = 2*i + 1;
		r = 2*i + 2;
		min = i;
		if(l < count && arr[l] < arr[i]) {
			min = l;
		}
		if(r < count && arr[min] > arr[r]) {
			min = r;
		}
		if(min != i) {
			temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			percolateDown(min);
		}
	}
	
	public void printHeap() {
		for(int i=0; i<count;i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
}
