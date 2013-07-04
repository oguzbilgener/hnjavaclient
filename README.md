hnjavaclient
============
<<<<<<< HEAD
A Hacker News Java Client Library (currently read-only)
This project is under active development.

Usage
-----

### Retrieve the homepage news
```java
HNClient hn = new HNClient();
ArrayList<NewsItem> newsList = hn.getNewsIndex();
```

### Retrieve the newest
```java
HNClient hn = new HNClient();
ArrayList<NewsItem> newsList = hn.getNewest();
```

### Retrieve the ask hn
```java
HNClient hn = new HNClient();
ArrayList<NewsItem> newsList = hn.getAsk();
```

### Retrieve the next page
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

More features are on the way...

=======

A Hacker News Java Client Library (currently read only)
>>>>>>> f3ba5e575f8013f784686a47aaddb06a437d4c17
