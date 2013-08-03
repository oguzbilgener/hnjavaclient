hnjavaclient
============
A Hacker News Java Client Library (currently read-only)

This project is under active development.

### Basic Features
- Retrieve news from trending/newest/ask
- Retrieve comments of an item


###Usage

```java
// Create the client object
HNClient hn = new HNClient();
// Retrieve the homepage news
ArrayList<NewsItem> indexList = hn.getNewsIndex();

// Retrieve the newest
ArrayList<NewsItem> newestList = hn.getNewest();

// Retrieve the ask hn
ArrayList<NewsItem> askList = hn.getAsk();
```

#### Retrieve the next page
```java
// Retrieve a page, as usual
HNClient hn = new HNClient();
ArrayList<NewsItem> newsList = hn.getNewsIndex();
// Get the next page link
String next = hn.getNextLink();
if(next != null)
{
	// Retrieve the next page
	ArrayList<NewsItem> nextList = hn.getNewsPage(next);
	// then comine two ArrayLists into one
	newsList.addAll(nextList);
}
```

#### Retrieve comments of an item
```java
// Create the client object
HNClient hn = new HNClient();
// Get the comments page link from somewhere
String url = "https://news.ycombinator.com/item?id=5987780";
// Retrieve the comments
ArrayList<CommentItem> commentsList = hn.getComments(url);
```

#### Warning
Always access the methods above from a thread or and async task. Downloading, parsing are time consuming tasks.
Also, you are going to need to surround them with a try/catch block. It is possible that the API throws IOException or BadStatusException.

More features are on the way...

