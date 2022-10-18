package org.example;



public class ListNumber<T> {

    /**
     * Это класс ListNumber, отвечающий за храние списка наших элеметов
     */
        protected Numbers <T> head;


        protected Numbers <T> tail;


        protected int size;


        /**
         *  Конструктор ListNumber инициализирует поля класса
         */
        public ListNumber () {
            head = null;
            tail = null;
            size = 0;
        }

        /**
         * Метод isEmpty провреряет на пустоту список
         * @return true в случае, если head=null и false в ином случае
         */
        public boolean isEmpty() {
            return head == null;
        }

        /**
         * Метод GetHead возвращает начало списка
         * @return head - указатель на голову
         */
        protected Numbers<T> GetHead()
        {
            return head;
        }

        /**
         * Метод findBeforePlace возвращает указател на следующий элемент после заданного
         * @param pNumbers указатель на элемент, с которого просиходит поиск
         * @param place место заданного элемента
         * @return p - указател на необходимый элемент
         */
        protected Numbers <T> findBeforePlace(Numbers <T> pNumbers, int place) {
            Numbers<T> p = null;
            Numbers<T> p1 = pNumbers;
            int place_find = 1;
            if(place<=size+1 && place!=1) {
                while (p1.next != null && place_find < place) {
                    place_find++;
                    p = p1;
                    p1 = p1.next;
                }
                if (p1.next == null && place_find != place) p=p1;
            }
            return p;
        }

        /**
         * Метод addToHead добавляет элемент в голову
         * @param new_x элемент, который необходимо добавить
         */
        protected void addToHead(T new_x) {
            Numbers<T> p = new Numbers(new_x);
            p.x = new_x;
            p.next = head;
            head = p;
            if(head.next==null) tail=head;
        }


        /**
         * Метод addAfterTail добавляет элемент в конец списка
         * @param new_x элемент, который необходимо добавить
         */
        protected void addAfterTail(T new_x) {
            Numbers<T> p = new Numbers(new_x);
            p.x = new_x;
            tail.next = p;
            tail = p;
        }

        /**
         * Метод addAfterListNumber добавляет элемент после заданного
         * @param new_x элемент, который необходимо добавить
         * @param pNumbers- указатель на элемент, после котрого необходимо добавить заданный
         */
        protected void addAfterListNumber(T new_x, Numbers <T> pNumbers) {
            if (pNumbers == tail) addAfterTail(new_x);
            else {
                Numbers<T> p = new Numbers(new_x);
                p.x = new_x;
                p.next = pNumbers.next;
                pNumbers.next = p;
            }
        }




    /**
         * Метод addNumber добавляет элемент в список на определенное место
         * @param new_x элемент, который необходимо добавить
         * @param place место, в кторое необходимо добавить элемент
         * @return true-в случае правильнрсти добавление и false - если  не возможно добавить
         */


        public boolean addNumber(T new_x, int place) {
            if (place <= size+1) {
                if (!isEmpty()) {
                    Numbers<T> p = findBeforePlace(head, place);

                    if (p == null) {
                        addToHead(new_x);
                    } else {

                        addAfterListNumber(new_x, p);

                    }
                } else addToHead(new_x);
                size++;
                return true;
            }
            return false;
        }


        /**
         * Метод deleteFromHead удаляет элемент из головы
         */
        protected void deleteFromHead() {
            if (!isEmpty()) {
                if (head == tail) {
                    head = null;
                    tail = null;

                } else {
                    Numbers p = head;
                    head = p.next;
                    p.next = null;
                    p = null;
                }
            }

        }


        /**
         * Метод deleteAfterListNumber удаляет элемент после заданного
         * @param pNumbers указатель на элемент, после котрого необходимо удалить элемент
         */
        protected void deleteAfterListNumber(Numbers <T> pNumbers) {
            Numbers<T> p = pNumbers.next;
            if (p == tail) {
                pNumbers.next = null;
                tail = pNumbers;
            }
            if (p != null) {
                pNumbers.next = p.next;
                p.next = null;
                p = null;
            }
        }


        /**
         * Метод addNumber добавляет элемент из списка по его номеру
         * @param place место, из которого необходимо удалить элемент
         * @return true-в случае правильнрсти добавление и false - если  не возможно добавить
         */

        public boolean deleteNumber(int place) {
            if (place <= size ) {
                Numbers<T> p = findBeforePlace(head, place);
                if (p == null)
                    deleteFromHead();
                else deleteAfterListNumber(p);

                size--;
                return true;
            }
            return false;
        }


        /**
         * Метод  getElem возвращает элемент по его месту
         * @param place место необходимого элемента
         * @return elem или null в случае не нахождение элемента
         */


        public T getElem(int place) {
            T elem;
            if (place <= size) {
                Numbers<T> p = findBeforePlace(head, place);
                if (p == null) elem = head.x;
                else elem = p.next.x;
                return elem;
            }
            return null;
        }


        /**
         * Метод print выводит список элементов
         * @return result - строка, включающая весь список
         */
        public String print() {
            String result=" ";
            if (!isEmpty()) {
                Numbers<T> p = head;
                while (p != null) {
                    result=result+p.x+" ";
                    p = p.next;
                }
            } else System.out.println("Набор пуст!");
            return result;
        }

}


