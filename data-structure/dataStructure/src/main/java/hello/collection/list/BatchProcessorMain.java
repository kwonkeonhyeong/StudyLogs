package hello.collection.list;

public class BatchProcessorMain {
    public static void main(String[] args) {

        MyArrayList<Integer> arrayList = new MyArrayList<>();
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        BatchProcessor batchProcessor = new BatchProcessor(linkedList);

        batchProcessor.logic(50_000);
    }
}
