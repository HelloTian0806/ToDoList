# TODO

## 待完成功能
- [ ] 刪除 Todo
- [ ] 修改 Todo
- [ ] 標記完成

## 其他

1.新增資料時不能有空白的問題

2.再新增一筆資料前確定id為最大值(使用getMaxId())，不過還有個問題當我刪除一筆資料時id的部分只會替代原本刪除的id編號，其他id不會跟著變動。
## 筆記
File file = new File("ToDoList.txt"); 是在建立跟檔案的連結並不會判斷是否有那個檔案，也不會建立檔案、讀取檔案，只是讓Java知道有一個檔案路徑叫做ToDoList.txt
可以使用 file.exists()去看檔案是否存在。

用BufferedReader讀取txt檔案
用BufferedWriter寫入檔案在(new FileWriter("ToDoList.txt", true))加上true為接續在原本資料上加上新的資料。

在Main的部分只處理使用者操作的問題，Modle中定義我的物件Todo，Service中為所有業務層面的方法。

一開始啟用程式的時候，先確認txt檔案是否存在，沒有的話建立一個txt檔案，檔案存在的話就用BufferedReader讀取並加入的todolist。

br.readLine()讀取一行資料。
運用.split(",")抓出我要的資料id, content, completed並且分別存入String[]

使用BufferedWriter bw = new BufferedWriter(new FileWriter("ToDoList.txt"));
會先清空整個txt檔案

把todoService的大部分方法寫成boolean，就可以直接在main判斷資料修改成不成功，就不用從todoService那邊回傳值再交給main判斷多做一動作。

更改了物件卻沒更改到實際的txt檔案，需要使用writer去修改，採用的方法是每次使用者刪除、修改、完成標記，都先清空檔案然後遍歷一遍ArrayList將每個Todo物件一個一個加上去。

使用BufferedWriter的時候將BufferedWriter寫在迴圈內部，等於說每次進到迴圈的時候都將檔案清掉，到最後只會剩下一筆資料。

要注意每個scn.next() or scn.nextLine()之後接下一個scn.next()是不是有把enter的部分讀取完成，不然會造成使用者新增或者使用其他功能時，新增的時候變成空字串。

在使用todolist.remove()，切記不要在迴圈內使用，在遍歷時修改ArrayList的大小很容易有問題(ConcurrentModificationException)。
用增強for迴圈會噴錯誤
如果在一般for迴圈內使用，原本的[A, B, C, D]當你把B刪掉的時候，會變成[A, C, D]，此時遍歷會跳過C直接到D
最好的方法是找到對應的id後再刪除。