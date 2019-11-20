/*
Задание:
Дано:
Строка (именно строка) длиной 9 символов, состоящая из нулей и единиц, например: “010101010”
Массив строк состоящий из 9 элементов, например: [“test”,”service2”,”dev”, “service4”,”test5”,”test6”,”test7”,”service8”,”prod”]
 
Необходимо:
написать программу, которая запрашивает строку и массив при запуске, затем формирует новый массив из строк по следующему алгоритму: в выходной массив строк 
добавляются элементы из входного массива строк, при условии что на позиции в строке (с нулями и единицами), соответствующей позиции элемента во входном массиве, 
присутствует единица “1”.
 
Для указанных примеров
 
“010101010” 
[“test”,”service2”,”dev”, “service4”,”test5”,”test6”,”test7”,”service8”,”prod”]
 
выходной массив будет следующий:
[”service2”,“service4”,”test6”,”service8”]
 */
package org.vasiliev.epoltesttask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EpolTestTask {

    public static void main(String[] args) throws IOException {
        
        System.out.println("Задайте колличество символов строки/колличество элементов массива:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        // проверяем чтобы строка была не пустая
        while(num.isEmpty()){
            System.out.println("Задайте колличество символов строки/колличество элементов массива:");
            num = br.readLine();
        }

        int num_elements = Integer.parseInt(num);
        
        System.out.println("Введите строку из нулей и единиц длинной: " + num_elements + " символов.");
        
        // использовал StringBuffer чтобы не плодить объекты класса String в памяти,
        // т.к. символ в строку добавляем только после проверки.
        StringBuilder s = new StringBuilder();                                  
        
        // в данном цикле заполняем строку 0 и 1 
        for(int i = 0; i < num_elements; ){                                     
            String symbol;
            symbol = br.readLine();
            // выполняем проверку на колличество символов в введенной строке
            while(symbol.length() > 1){                                         
                System.out.println("Введите один символ!!");
                symbol = br.readLine();
            }
            
            // проверяем, что переменная ch содердит только 0 или 1
            // если проверка проедена записываем символ в строку
            char ch = symbol.charAt(0);                                         
            if(ch == '0' | ch == '1'){                                          
                s.append(ch);           
                i++;
            }else System.out.println("Введите 0 или 1"); 
        }
        
        System.out.println("Заполните массив строками: ");
        // создаем массив строк заданной размерности
        String arr[] = new String[num_elements];                                
        
        // заполняем исходный массив строками
        for (int i = 0; i < arr.length; i++){
            String temp = br.readLine();
            //проверяем чтобы строка была не пустая
            while(temp.isEmpty()){
                System.out.println("Вы ввели пустую строку, повторите ввод!");
                temp = br.readLine();
            }
            arr[i] = temp;
        }
        
        // переменная, которая будет хранить размерность нового массива
        int newArraySize = 0;                                                   
        
        // выводим в консоль содержимое исходной строки
        System.out.println("Строка содержит: " + s);
        // выводим в консоль содержимое исходного массива
        System.out.println("Массив содержит: " + Arrays.toString(arr));         
        
        // в этом цикле подсчитываем размерность нового массива  
        for (int i = 0; i < arr.length; i++ ){                                  
            if( s.charAt(i) == '1'){
                newArraySize++;
            }
        }
        
        //выводим в консоль размерность нового массива
        System.out.println("Размерность нового массива: " + newArraySize);
        
        // объявили новый массив необходимой размерности
        String[] arr2 = new String[newArraySize];                               
        int index = 0;
        
        // заполняем новый массив элементами в соответствии с условие задачи
        for(int i=0; i < arr.length; i++){                                      
            if(s.charAt(i) == '1'){
                arr2[index] = arr[i];
                index++;
            }       
        }
        
        // выводим в консоль содержимое нового массива
        System.out.println("Новый массив содержит: " + Arrays.toString(arr2));  
    } 
}
