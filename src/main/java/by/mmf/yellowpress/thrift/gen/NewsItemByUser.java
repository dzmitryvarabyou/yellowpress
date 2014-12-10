/**
 * Autogenerated by Thrift Compiler (0.9.1)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package by.mmf.yellowpress.thrift.gen;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;

import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;

public class NewsItemByUser implements org.apache.thrift.TBase<NewsItemByUser, NewsItemByUser._Fields>, java.io.Serializable, Cloneable, Comparable<NewsItemByUser> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("NewsItemByUser");

  private static final org.apache.thrift.protocol.TField USER_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("userId", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TAG_FIELD_DESC = new org.apache.thrift.protocol.TField("tag", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PUBLISHED_AT_FIELD_DESC = new org.apache.thrift.protocol.TField("publishedAt", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField NEWS_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("newsId", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField TITLE_FIELD_DESC = new org.apache.thrift.protocol.TField("title", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField DESCRIPTION_FIELD_DESC = new org.apache.thrift.protocol.TField("description", org.apache.thrift.protocol.TType.STRING, (short)6);
  private static final org.apache.thrift.protocol.TField IMAGE_URL_FIELD_DESC = new org.apache.thrift.protocol.TField("imageUrl", org.apache.thrift.protocol.TType.STRING, (short)7);
  private static final org.apache.thrift.protocol.TField FACULTY_FIELD_DESC = new org.apache.thrift.protocol.TField("faculty", org.apache.thrift.protocol.TType.STRING, (short)8);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new NewsItemByUserStandardSchemeFactory());
    schemes.put(TupleScheme.class, new NewsItemByUserTupleSchemeFactory());
  }

  public String userId; // required
  public String tag; // required
  public String publishedAt; // required
  public String newsId; // required
  public String title; // required
  public String description; // required
  public String imageUrl; // required
  public String faculty; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    USER_ID((short)1, "userId"),
    TAG((short)2, "tag"),
    PUBLISHED_AT((short)3, "publishedAt"),
    NEWS_ID((short)4, "newsId"),
    TITLE((short)5, "title"),
    DESCRIPTION((short)6, "description"),
    IMAGE_URL((short)7, "imageUrl"),
    FACULTY((short)8, "faculty");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // USER_ID
          return USER_ID;
        case 2: // TAG
          return TAG;
        case 3: // PUBLISHED_AT
          return PUBLISHED_AT;
        case 4: // NEWS_ID
          return NEWS_ID;
        case 5: // TITLE
          return TITLE;
        case 6: // DESCRIPTION
          return DESCRIPTION;
        case 7: // IMAGE_URL
          return IMAGE_URL;
        case 8: // FACULTY
          return FACULTY;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.USER_ID, new org.apache.thrift.meta_data.FieldMetaData("userId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TAG, new org.apache.thrift.meta_data.FieldMetaData("tag", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PUBLISHED_AT, new org.apache.thrift.meta_data.FieldMetaData("publishedAt", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.NEWS_ID, new org.apache.thrift.meta_data.FieldMetaData("newsId", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TITLE, new org.apache.thrift.meta_data.FieldMetaData("title", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.DESCRIPTION, new org.apache.thrift.meta_data.FieldMetaData("description", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.IMAGE_URL, new org.apache.thrift.meta_data.FieldMetaData("imageUrl", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.FACULTY, new org.apache.thrift.meta_data.FieldMetaData("faculty", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(NewsItemByUser.class, metaDataMap);
  }

  public NewsItemByUser() {
  }

  public NewsItemByUser(
    String userId,
    String tag,
    String publishedAt,
    String newsId,
    String title,
    String description,
    String imageUrl,
    String faculty)
  {
    this();
    this.userId = userId;
    this.tag = tag;
    this.publishedAt = publishedAt;
    this.newsId = newsId;
    this.title = title;
    this.description = description;
    this.imageUrl = imageUrl;
    this.faculty = faculty;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public NewsItemByUser(NewsItemByUser other) {
    if (other.isSetUserId()) {
      this.userId = other.userId;
    }
    if (other.isSetTag()) {
      this.tag = other.tag;
    }
    if (other.isSetPublishedAt()) {
      this.publishedAt = other.publishedAt;
    }
    if (other.isSetNewsId()) {
      this.newsId = other.newsId;
    }
    if (other.isSetTitle()) {
      this.title = other.title;
    }
    if (other.isSetDescription()) {
      this.description = other.description;
    }
    if (other.isSetImageUrl()) {
      this.imageUrl = other.imageUrl;
    }
    if (other.isSetFaculty()) {
      this.faculty = other.faculty;
    }
  }

  public NewsItemByUser deepCopy() {
    return new NewsItemByUser(this);
  }

  @Override
  public void clear() {
    this.userId = null;
    this.tag = null;
    this.publishedAt = null;
    this.newsId = null;
    this.title = null;
    this.description = null;
    this.imageUrl = null;
    this.faculty = null;
  }

  public String getUserId() {
    return this.userId;
  }

  public NewsItemByUser setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public void unsetUserId() {
    this.userId = null;
  }

  /** Returns true if field userId is set (has been assigned a value) and false otherwise */
  public boolean isSetUserId() {
    return this.userId != null;
  }

  public void setUserIdIsSet(boolean value) {
    if (!value) {
      this.userId = null;
    }
  }

  public String getTag() {
    return this.tag;
  }

  public NewsItemByUser setTag(String tag) {
    this.tag = tag;
    return this;
  }

  public void unsetTag() {
    this.tag = null;
  }

  /** Returns true if field tag is set (has been assigned a value) and false otherwise */
  public boolean isSetTag() {
    return this.tag != null;
  }

  public void setTagIsSet(boolean value) {
    if (!value) {
      this.tag = null;
    }
  }

  public String getPublishedAt() {
    return this.publishedAt;
  }

  public NewsItemByUser setPublishedAt(String publishedAt) {
    this.publishedAt = publishedAt;
    return this;
  }

  public void unsetPublishedAt() {
    this.publishedAt = null;
  }

  /** Returns true if field publishedAt is set (has been assigned a value) and false otherwise */
  public boolean isSetPublishedAt() {
    return this.publishedAt != null;
  }

  public void setPublishedAtIsSet(boolean value) {
    if (!value) {
      this.publishedAt = null;
    }
  }

  public String getNewsId() {
    return this.newsId;
  }

  public NewsItemByUser setNewsId(String newsId) {
    this.newsId = newsId;
    return this;
  }

  public void unsetNewsId() {
    this.newsId = null;
  }

  /** Returns true if field newsId is set (has been assigned a value) and false otherwise */
  public boolean isSetNewsId() {
    return this.newsId != null;
  }

  public void setNewsIdIsSet(boolean value) {
    if (!value) {
      this.newsId = null;
    }
  }

  public String getTitle() {
    return this.title;
  }

  public NewsItemByUser setTitle(String title) {
    this.title = title;
    return this;
  }

  public void unsetTitle() {
    this.title = null;
  }

  /** Returns true if field title is set (has been assigned a value) and false otherwise */
  public boolean isSetTitle() {
    return this.title != null;
  }

  public void setTitleIsSet(boolean value) {
    if (!value) {
      this.title = null;
    }
  }

  public String getDescription() {
    return this.description;
  }

  public NewsItemByUser setDescription(String description) {
    this.description = description;
    return this;
  }

  public void unsetDescription() {
    this.description = null;
  }

  /** Returns true if field description is set (has been assigned a value) and false otherwise */
  public boolean isSetDescription() {
    return this.description != null;
  }

  public void setDescriptionIsSet(boolean value) {
    if (!value) {
      this.description = null;
    }
  }

  public String getImageUrl() {
    return this.imageUrl;
  }

  public NewsItemByUser setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  public void unsetImageUrl() {
    this.imageUrl = null;
  }

  /** Returns true if field imageUrl is set (has been assigned a value) and false otherwise */
  public boolean isSetImageUrl() {
    return this.imageUrl != null;
  }

  public void setImageUrlIsSet(boolean value) {
    if (!value) {
      this.imageUrl = null;
    }
  }

  public String getFaculty() {
    return this.faculty;
  }

  public NewsItemByUser setFaculty(String faculty) {
    this.faculty = faculty;
    return this;
  }

  public void unsetFaculty() {
    this.faculty = null;
  }

  /** Returns true if field faculty is set (has been assigned a value) and false otherwise */
  public boolean isSetFaculty() {
    return this.faculty != null;
  }

  public void setFacultyIsSet(boolean value) {
    if (!value) {
      this.faculty = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case USER_ID:
      if (value == null) {
        unsetUserId();
      } else {
        setUserId((String)value);
      }
      break;

    case TAG:
      if (value == null) {
        unsetTag();
      } else {
        setTag((String)value);
      }
      break;

    case PUBLISHED_AT:
      if (value == null) {
        unsetPublishedAt();
      } else {
        setPublishedAt((String)value);
      }
      break;

    case NEWS_ID:
      if (value == null) {
        unsetNewsId();
      } else {
        setNewsId((String)value);
      }
      break;

    case TITLE:
      if (value == null) {
        unsetTitle();
      } else {
        setTitle((String)value);
      }
      break;

    case DESCRIPTION:
      if (value == null) {
        unsetDescription();
      } else {
        setDescription((String)value);
      }
      break;

    case IMAGE_URL:
      if (value == null) {
        unsetImageUrl();
      } else {
        setImageUrl((String)value);
      }
      break;

    case FACULTY:
      if (value == null) {
        unsetFaculty();
      } else {
        setFaculty((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case USER_ID:
      return getUserId();

    case TAG:
      return getTag();

    case PUBLISHED_AT:
      return getPublishedAt();

    case NEWS_ID:
      return getNewsId();

    case TITLE:
      return getTitle();

    case DESCRIPTION:
      return getDescription();

    case IMAGE_URL:
      return getImageUrl();

    case FACULTY:
      return getFaculty();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case USER_ID:
      return isSetUserId();
    case TAG:
      return isSetTag();
    case PUBLISHED_AT:
      return isSetPublishedAt();
    case NEWS_ID:
      return isSetNewsId();
    case TITLE:
      return isSetTitle();
    case DESCRIPTION:
      return isSetDescription();
    case IMAGE_URL:
      return isSetImageUrl();
    case FACULTY:
      return isSetFaculty();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof NewsItemByUser)
      return this.equals((NewsItemByUser)that);
    return false;
  }

  public boolean equals(NewsItemByUser that) {
    if (that == null)
      return false;

    boolean this_present_userId = true && this.isSetUserId();
    boolean that_present_userId = true && that.isSetUserId();
    if (this_present_userId || that_present_userId) {
      if (!(this_present_userId && that_present_userId))
        return false;
      if (!this.userId.equals(that.userId))
        return false;
    }

    boolean this_present_tag = true && this.isSetTag();
    boolean that_present_tag = true && that.isSetTag();
    if (this_present_tag || that_present_tag) {
      if (!(this_present_tag && that_present_tag))
        return false;
      if (!this.tag.equals(that.tag))
        return false;
    }

    boolean this_present_publishedAt = true && this.isSetPublishedAt();
    boolean that_present_publishedAt = true && that.isSetPublishedAt();
    if (this_present_publishedAt || that_present_publishedAt) {
      if (!(this_present_publishedAt && that_present_publishedAt))
        return false;
      if (!this.publishedAt.equals(that.publishedAt))
        return false;
    }

    boolean this_present_newsId = true && this.isSetNewsId();
    boolean that_present_newsId = true && that.isSetNewsId();
    if (this_present_newsId || that_present_newsId) {
      if (!(this_present_newsId && that_present_newsId))
        return false;
      if (!this.newsId.equals(that.newsId))
        return false;
    }

    boolean this_present_title = true && this.isSetTitle();
    boolean that_present_title = true && that.isSetTitle();
    if (this_present_title || that_present_title) {
      if (!(this_present_title && that_present_title))
        return false;
      if (!this.title.equals(that.title))
        return false;
    }

    boolean this_present_description = true && this.isSetDescription();
    boolean that_present_description = true && that.isSetDescription();
    if (this_present_description || that_present_description) {
      if (!(this_present_description && that_present_description))
        return false;
      if (!this.description.equals(that.description))
        return false;
    }

    boolean this_present_imageUrl = true && this.isSetImageUrl();
    boolean that_present_imageUrl = true && that.isSetImageUrl();
    if (this_present_imageUrl || that_present_imageUrl) {
      if (!(this_present_imageUrl && that_present_imageUrl))
        return false;
      if (!this.imageUrl.equals(that.imageUrl))
        return false;
    }

    boolean this_present_faculty = true && this.isSetFaculty();
    boolean that_present_faculty = true && that.isSetFaculty();
    if (this_present_faculty || that_present_faculty) {
      if (!(this_present_faculty && that_present_faculty))
        return false;
      if (!this.faculty.equals(that.faculty))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_userId = true && (isSetUserId());
    builder.append(present_userId);
    if (present_userId)
      builder.append(userId);

    boolean present_tag = true && (isSetTag());
    builder.append(present_tag);
    if (present_tag)
      builder.append(tag);

    boolean present_publishedAt = true && (isSetPublishedAt());
    builder.append(present_publishedAt);
    if (present_publishedAt)
      builder.append(publishedAt);

    boolean present_newsId = true && (isSetNewsId());
    builder.append(present_newsId);
    if (present_newsId)
      builder.append(newsId);

    boolean present_title = true && (isSetTitle());
    builder.append(present_title);
    if (present_title)
      builder.append(title);

    boolean present_description = true && (isSetDescription());
    builder.append(present_description);
    if (present_description)
      builder.append(description);

    boolean present_imageUrl = true && (isSetImageUrl());
    builder.append(present_imageUrl);
    if (present_imageUrl)
      builder.append(imageUrl);

    boolean present_faculty = true && (isSetFaculty());
    builder.append(present_faculty);
    if (present_faculty)
      builder.append(faculty);

    return builder.toHashCode();
  }

  @Override
  public int compareTo(NewsItemByUser other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetUserId()).compareTo(other.isSetUserId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userId, other.userId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTag()).compareTo(other.isSetTag());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTag()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tag, other.tag);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPublishedAt()).compareTo(other.isSetPublishedAt());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPublishedAt()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.publishedAt, other.publishedAt);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNewsId()).compareTo(other.isSetNewsId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNewsId()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.newsId, other.newsId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTitle()).compareTo(other.isSetTitle());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTitle()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.title, other.title);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDescription()).compareTo(other.isSetDescription());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDescription()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.description, other.description);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetImageUrl()).compareTo(other.isSetImageUrl());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetImageUrl()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.imageUrl, other.imageUrl);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFaculty()).compareTo(other.isSetFaculty());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFaculty()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.faculty, other.faculty);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("NewsItemByUser(");
    boolean first = true;

    sb.append("userId:");
    if (this.userId == null) {
      sb.append("null");
    } else {
      sb.append(this.userId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("tag:");
    if (this.tag == null) {
      sb.append("null");
    } else {
      sb.append(this.tag);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("publishedAt:");
    if (this.publishedAt == null) {
      sb.append("null");
    } else {
      sb.append(this.publishedAt);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("newsId:");
    if (this.newsId == null) {
      sb.append("null");
    } else {
      sb.append(this.newsId);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("title:");
    if (this.title == null) {
      sb.append("null");
    } else {
      sb.append(this.title);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("description:");
    if (this.description == null) {
      sb.append("null");
    } else {
      sb.append(this.description);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("imageUrl:");
    if (this.imageUrl == null) {
      sb.append("null");
    } else {
      sb.append(this.imageUrl);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("faculty:");
    if (this.faculty == null) {
      sb.append("null");
    } else {
      sb.append(this.faculty);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class NewsItemByUserStandardSchemeFactory implements SchemeFactory {
    public NewsItemByUserStandardScheme getScheme() {
      return new NewsItemByUserStandardScheme();
    }
  }

  private static class NewsItemByUserStandardScheme extends StandardScheme<NewsItemByUser> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, NewsItemByUser struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // USER_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.userId = iprot.readString();
              struct.setUserIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TAG
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.tag = iprot.readString();
              struct.setTagIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // PUBLISHED_AT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.publishedAt = iprot.readString();
              struct.setPublishedAtIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // NEWS_ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.newsId = iprot.readString();
              struct.setNewsIdIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // TITLE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.title = iprot.readString();
              struct.setTitleIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // DESCRIPTION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.description = iprot.readString();
              struct.setDescriptionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // IMAGE_URL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.imageUrl = iprot.readString();
              struct.setImageUrlIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 8: // FACULTY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.faculty = iprot.readString();
              struct.setFacultyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, NewsItemByUser struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.userId != null) {
        oprot.writeFieldBegin(USER_ID_FIELD_DESC);
        oprot.writeString(struct.userId);
        oprot.writeFieldEnd();
      }
      if (struct.tag != null) {
        oprot.writeFieldBegin(TAG_FIELD_DESC);
        oprot.writeString(struct.tag);
        oprot.writeFieldEnd();
      }
      if (struct.publishedAt != null) {
        oprot.writeFieldBegin(PUBLISHED_AT_FIELD_DESC);
        oprot.writeString(struct.publishedAt);
        oprot.writeFieldEnd();
      }
      if (struct.newsId != null) {
        oprot.writeFieldBegin(NEWS_ID_FIELD_DESC);
        oprot.writeString(struct.newsId);
        oprot.writeFieldEnd();
      }
      if (struct.title != null) {
        oprot.writeFieldBegin(TITLE_FIELD_DESC);
        oprot.writeString(struct.title);
        oprot.writeFieldEnd();
      }
      if (struct.description != null) {
        oprot.writeFieldBegin(DESCRIPTION_FIELD_DESC);
        oprot.writeString(struct.description);
        oprot.writeFieldEnd();
      }
      if (struct.imageUrl != null) {
        oprot.writeFieldBegin(IMAGE_URL_FIELD_DESC);
        oprot.writeString(struct.imageUrl);
        oprot.writeFieldEnd();
      }
      if (struct.faculty != null) {
        oprot.writeFieldBegin(FACULTY_FIELD_DESC);
        oprot.writeString(struct.faculty);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class NewsItemByUserTupleSchemeFactory implements SchemeFactory {
    public NewsItemByUserTupleScheme getScheme() {
      return new NewsItemByUserTupleScheme();
    }
  }

  private static class NewsItemByUserTupleScheme extends TupleScheme<NewsItemByUser> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, NewsItemByUser struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      BitSet optionals = new BitSet();
      if (struct.isSetUserId()) {
        optionals.set(0);
      }
      if (struct.isSetTag()) {
        optionals.set(1);
      }
      if (struct.isSetPublishedAt()) {
        optionals.set(2);
      }
      if (struct.isSetNewsId()) {
        optionals.set(3);
      }
      if (struct.isSetTitle()) {
        optionals.set(4);
      }
      if (struct.isSetDescription()) {
        optionals.set(5);
      }
      if (struct.isSetImageUrl()) {
        optionals.set(6);
      }
      if (struct.isSetFaculty()) {
        optionals.set(7);
      }
      oprot.writeBitSet(optionals, 8);
      if (struct.isSetUserId()) {
        oprot.writeString(struct.userId);
      }
      if (struct.isSetTag()) {
        oprot.writeString(struct.tag);
      }
      if (struct.isSetPublishedAt()) {
        oprot.writeString(struct.publishedAt);
      }
      if (struct.isSetNewsId()) {
        oprot.writeString(struct.newsId);
      }
      if (struct.isSetTitle()) {
        oprot.writeString(struct.title);
      }
      if (struct.isSetDescription()) {
        oprot.writeString(struct.description);
      }
      if (struct.isSetImageUrl()) {
        oprot.writeString(struct.imageUrl);
      }
      if (struct.isSetFaculty()) {
        oprot.writeString(struct.faculty);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, NewsItemByUser struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      BitSet incoming = iprot.readBitSet(8);
      if (incoming.get(0)) {
        struct.userId = iprot.readString();
        struct.setUserIdIsSet(true);
      }
      if (incoming.get(1)) {
        struct.tag = iprot.readString();
        struct.setTagIsSet(true);
      }
      if (incoming.get(2)) {
        struct.publishedAt = iprot.readString();
        struct.setPublishedAtIsSet(true);
      }
      if (incoming.get(3)) {
        struct.newsId = iprot.readString();
        struct.setNewsIdIsSet(true);
      }
      if (incoming.get(4)) {
        struct.title = iprot.readString();
        struct.setTitleIsSet(true);
      }
      if (incoming.get(5)) {
        struct.description = iprot.readString();
        struct.setDescriptionIsSet(true);
      }
      if (incoming.get(6)) {
        struct.imageUrl = iprot.readString();
        struct.setImageUrlIsSet(true);
      }
      if (incoming.get(7)) {
        struct.faculty = iprot.readString();
        struct.setFacultyIsSet(true);
      }
    }
  }

}
