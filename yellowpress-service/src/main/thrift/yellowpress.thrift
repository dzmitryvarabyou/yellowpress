namespace java by.mmf.yellowpress.thrift

struct NewsItemT{
 1: string newsId,
 2: string publishedAt,
 3: string lastModifiedAt,
 4: string faculty,
 5: string title,
 6: string body,
 7: string description,
 8: string imageUrl,
 9: list<string> tags;
}

struct NewsItemByUserT{
 1: string userId,
 2: string tag,
 3: string publishedAt,
 4: string newsId,
 5: string title,
 6: string description,
 7: string imageUrl,
 8: string faculty;
}

struct UserT{
 1: string userId,
 2: string userEmail,
 3: string userPass,
 4: list<string> subscribedTags,
 5: list<string> subscribedFaculties;
}

enum YellowPressErrorCodeT {
	INTERNAL_ERROR = 1
}

exception YellowPressExceptionT {
	1:required YellowPressErrorCodeT errorCode;
	2:string message;
}

service YellowPressServiceT {

	void subscribe(1:string userId, 2:string tag) throws (1:YellowPressExceptionT exp),

    list<NewsItemByUserT> getNewsByUser(1:string userId) throws (1:YellowPressExceptionT exp),

    list<string> getAllSubscribedTags(1:string userId) throws (1:YellowPressExceptionT exp),

    void removeSubscription(1:string userId, 2:string tag) throws (1:YellowPressExceptionT exp),

    list<NewsItemT> getAllNewsPreviews() throws (1:YellowPressExceptionT exp),

    list<NewsItemT> getNewsPreviewsByFacultyAndTags(1:string faculty, 2:list<string> tags) throws (1:YellowPressExceptionT exp),

    NewsItemT getNewsItem(1:string newsItemId) throws (1:YellowPressExceptionT exp)
}