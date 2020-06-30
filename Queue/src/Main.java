public class Main {
    public static void main(String[] args){

        /*// java数组必须初始化
        int[] arr = new int[20];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        int [] scores = new int[]{98, 99, 100};
        for(int score:scores)
            System.out.println(score);
        System.out.println("hello world");*/

        // 泛型不能存基本数据类型，需要存放对应包装类
        Array<Integer> arr = new Array<>(5);
        for(int i = 0; i < 10; i++){
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(100,1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);
    }
}
