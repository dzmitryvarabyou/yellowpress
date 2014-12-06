namespace java by.mmf.yellowpress

struct NewsItem{
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

struct NewsItemByUser{
 1: string userId,
 2: string tag,
 3: string publishedAt,
 4: string newsId,
 5: string title,
 6: string description,
 7: string imageUrl,
 8: string faculty;
}

struct User{
 1: string userId,
 2: string userEmail,
 3: string userPass,
 4: list<string> subscribedTags,
 5: list<string> subscribedFaculties;
}

enum YellowPressErrorCode {
	INTERNAL_ERROR = 1
}

exception YellowPressException {
	1:required YellowPressErrorCode errorCode;
	2:string message;
}

service YellowPressService {
	void subscribe(1:string usedId, 2:string tag) throws (1:YellowPressException exp),
    list<NewsItemByUser> getNewsByUser(1:string userId) throws (1:YellowPressException exp)
}