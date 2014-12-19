------------------------------
-- Keyspace
------------------------------

DROP KEYSPACE user_news;

CREATE KEYSPACE yellowpress WITH
 REPLICATION = {'class' : 'SimpleStrategy', 'replication_factor': 1};

 USE yellowpress;
------------------------------
-- news data store
------------------------------
CREATE TABLE IF NOT EXISTS news (
  news_id varchar,
  published_at timestamp,
  last_modified_at timestamp,
  title varchar,
  body varchar,
  description varchar,
  faculty varchar,
  image_url varchar,
  tags list<varchar>,
  PRIMARY KEY (news_id, published_at));

CREATE INDEX IF NOT EXISTS ON yellowpress.news (faculty);
CREATE INDEX IF NOT EXISTS ON yellowpress.news (tags);

------------------------------
-- users data store
------------------------------
CREATE TABLE IF NOT EXISTS users (
  user_id varchar,
  user_email varchar,
  user_pass varchar,
  subscribed_tags list<varchar>,
  subscribed_faculties list<varchar>,
  PRIMARY KEY (user_id));

CREATE INDEX IF NOT EXISTS ON yellowpress.users (subscribed_tags);

------------------------------
-- news_by_user data store
------------------------------
CREATE TABLE IF NOT EXISTS news_by_user (
  user_id varchar,
  tag varchar,
  published_at timestamp,
  news_id varchar,
  faculty varchar,
  title varchar,
  description varchar,
  image_url varchar,
  PRIMARY KEY (user_id, tag, published_at, news_id));

CREATE INDEX IF NOT EXISTS ON yellowpress.news_by_user (faculty);
CREATE INDEX IF NOT EXISTS ON yellowpress.news_by_user (faculty);