hnjavaclient
============
A Hacker News Java Client Library (currently read-only)

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
// Get the Original Post
NewsItem op = hn.getOriginalPostForComment();
```

#### Warning
Always access the methods above from a background thread. Also, surround your code with a try/catch block, in case of an IOException.

