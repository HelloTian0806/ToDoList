# TODO

## 待完成功能
- [ ] 刪除 Todo
- [ ] 修改 Todo
- [ ] 標記完成

## 其他

1.新增資料時不能有空白的問題

2.再新增一筆資料前確定id為最大值(使用getMaxId())，不過還有個問題當我刪除一筆資料時id的部分只會替代原本刪除的id編號，其他id不會跟著變動。
## 筆記

用BufferedReader讀取txt檔案
用BufferedWriter寫入檔案在(new FileWriter("ToDoList.txt", true))加上true為接續在原本資料上加上新的資料。

在Main的部分只處理使用者操作的問題，Modle中定義我的物件Todo，Service中為所有業務層面的方法。

一開始啟用程式的時候，先確認txt檔案是否存在，沒有的話建立一個txt檔案，檔案存在的話就用BufferedReader讀取並加入的todolist。

br.readLine()讀取一行資料。
運用.split(",")抓出我要的資料id, content, completed並且分別存入String[]

