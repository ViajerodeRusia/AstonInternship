package com.aston.AstonInternship.JavaCollections;

import java.util.Arrays;

public class MyArrayList<T extends Comparable<T>> {
    private int initSize = 10;
    private int cutRate = 4; // коэфф по которому определяем уменьшение массива
    private int pointer = 0; // счетчик текущего кол-ва эл-в
     Object[] array =new Object[initSize];

     public void add(T item) {
        // Проверяем заполненность всего массива
         if(pointer == array.length) {
            resize(array.length*1.5);
         }
         array[pointer++] = item;
     }

    private void resize(double newLength) {
        Object[] newArray = new Object[(int) newLength];
        System.arraycopy(array, 0 , newArray, 0, pointer);
        array = newArray; // переназначение ссылки
    }
    public T get(int index) {
        return (T) array[index];
    }

    public void remove(int index) {
        for (int i = index; i < pointer; i++) { // цикл от запрашиваемого элемента до последнего элемента в нашем массиве
            array[i] = array[i+1]; // перекладываем их влево
            array[pointer] = null; // последний зануляем
            pointer--; // число эл-в уменьшилось на 1
            if(array.length > initSize && pointer < array.length/cutRate) {
                resize(array.length/2);
            }
        }
    }

    public void quicksort() {
        quicksort(0, pointer - 1);
    }

    private void quicksort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quicksort(low, pivotIndex - 1); // Сортируем левую часть
            quicksort(pivotIndex + 1, high); // Сортируем правую часть
        }
    }

    private int partition(int low, int high) {
        T pivot = (T) array[high]; // Выбираем последний элемент в качестве опорного
        int i = low - 1; // Индекс меньшего элемента

        for (int j = low; j < high; j++) {
            if (((T) array[j]).compareTo(pivot) <= 0) { // Если текущий элемент меньше или равен опорному
                i++;
                // Меняем местами
                Object temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // Меняем местами опорный элемент с элементом на позиции i + 1
        Object temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // Возвращаем индекс опорного элемента
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyArrayList{");
        for (int i = 0; i < pointer; i++) {
            sb.append(array[i]);
            if (i < pointer - 1) { // Добавляем запятую только если это не последний элемент
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
