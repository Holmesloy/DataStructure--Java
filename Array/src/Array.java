public class Array<E> {

    // 泛型
    private E[] data;
    private int size;

    // 构造函数，传入数组容量capacity
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    // 无参数构造函数，默认数组容量为10
    public Array(){
        this(10);
    }

    // 获取数组元素个数
    public int getSize(){
        return size;
    }

    // 获取数组容量
    public int getCapacity(){
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 末尾添加一个新元素
    public void addLast(E e){
        add(e, size);
    }

    // 获取index处的元素
    public E get(int index){
        if(index < 0 || index>=size)
            throw new IllegalArgumentException("error");
        return data[index];
    }

    // 修改index处的元素
    public void set(int index, E e){
        if(index < 0 || index>=size)
            throw new IllegalArgumentException("error");
        data[index] = e;
    }

    // index处插入一个新元素e
    public void add(E e, int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("error");
        }
        // 动态数组，扩容
        if(size == data.length){
            resize(2 * data.length);
        }

        for(int i = size-1; i > index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;

    }

    // 查找e
    public boolean contains(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    // 查找e的索引
    public int find(E e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    // 删除index处的元素
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("error");
        }
        E e = data[index];
        for(int i = index + 1; i < size; i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;

        // 动态减小数组容量(lazy方式，防止复杂度震荡）
        if(size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return e;
    }

    // 删除e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d capacity = %d\n", size, data.length ));
        res.append("[");
        for(int i = 0; i < size; i++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }

    // 扩容方法
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }


}
