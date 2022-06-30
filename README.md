# サーバサイドKotlin 課題制作

バックエンドのほうです。<br>
フロントは[こっち](https://github.com/itc-s21009/news_manager_front)です。

## 工夫したところ

- `/news?page=3` のように、ページを指定して10件ずつ表示できるようにしました。
- `ADMIN` の権限がない場合は、公開日時がまだ来ていないニュースを取得できないようにしました。
- ニュースなので、新着順で表示するようにしました。

## 使い方
`POST`と`PUT`のリクエストは、[NewsForm](./src/main/kotlin/jp/ac/it_college/std/s21009/news_manager/presentation/form/NewsForm.kt)に書いてある形で送れます。

| 説明       | 宛先                      | メソッド     |
|----------|-------------------------|----------|
| ニュース一覧取得 | `/news`                 | `GET`    |
| ニュース個別取得 | `/news/{id}`            | `GET`    |
| ニュース登録   | `/news/register`        | `POST`   |
| ユーザー登録   | `/admin/user/register`  | `POST`   |
| カテゴリ登録   | `/category/register`    | `POST`   |
| カテゴリ更新   | `/category/update`      | `PUT`    |
| カテゴリ削除   | `/category/delete/{id}` | `DELETE` |