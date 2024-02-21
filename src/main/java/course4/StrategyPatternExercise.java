package course4;

/*
Implementarea Strategy Pattern pentru un sistem de sortare

Cerință: Implementați un Strategy Pattern pentru a permite sortarea unei liste de numere folosind diferite algoritmi
de sortare, cum ar fi Bubble Sort, Quick Sort și Merge Sort.

 */

        interface SortStrategy{
            void sort(int data[]);
        }

class BubbleSort implements SortStrategy {

    @Override
    public void sort(int data[]) {
        System.out.println("Sortare folosind BubbleSort");
        int n = data.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (data[j] > data[j + 1]) {
                    // swap temp and arr[i]
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;

                }
        for (int i = 0; i < n; ++i)
            System.out.print(data[i] + " ");
        System.out.println();
    }
}

class QuickSort implements SortStrategy {
    @Override
    public void sort(int[] data) {
        System.out.println("Sortare folosind Quick Sort");
        quickSort(data, 0, data.length - 1);
        int n = data.length;
        for (int i = 0; i < n; ++i)
            System.out.print(data[i] + " ");
        System.out.println();
    }
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }

    }
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
class MergeSort implements SortStrategy{
    @Override
    public void sort(int[] data) {
        System.out.println("Sortare folosind Merge Sort");
        mergeSort(data, 0, data.length - 1);
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    private void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }
    private void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[arr.length];
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }

        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }

    }
}

class Context {
    private SortStrategy sortStrategy;

    public Context(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void executeStrategy(int data[]) {
        sortStrategy.sort(data);
    }
}

public class StrategyPatternExercise {
    public static void main(String[] args) {
        int[] data = { 10, 7, 8, 9, 1,11, 5 };

        Context context = new Context(new MergeSort());
        context.executeStrategy(data);

        context.setSortStrategy(new BubbleSort());
        context.executeStrategy(data);

        context.setSortStrategy(new QuickSort());
        context.executeStrategy(data);
    }
}


