/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package by.mmf.yellowpress.thrift;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.async.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;

// No additional import required for struct/union.

public class NewsItemByUserT implements TBase<NewsItemByUserT, NewsItemByUserT._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("NewsItemByUserT");

  private static final TField USER_ID_FIELD_DESC = new TField("userId", TType.STRING, (short)1);
  private static final TField TAG_FIELD_DESC = new TField("tag", TType.STRING, (short)2);
  private static final TField PUBLISHED_AT_FIELD_DESC = new TField("publishedAt", TType.STRING, (short)3);
  private static final TField NEWS_ID_FIELD_DESC = new TField("newsId", TType.STRING, (short)4);
  private static final TField TITLE_FIELD_DESC = new TField("title", TType.STRING, (short)5);
  private static final TField DESCRIPTION_FIELD_DESC = new TField("description", TType.STRING, (short)6);
  private static final TField IMAGE_URL_FIELD_DESC = new TField("imageUrl", TType.STRING, (short)7);
  private static final TField FACULTY_FIELD_DESC = new TField("faculty", TType.STRING, (short)8);

  public String userId;
  public String tag;
  public String publishedAt;
  public String newsId;
  public String title;
  public String description;
  public String imageUrl;
  public String faculty;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
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

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.USER_ID, new FieldMetaData("userId", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.TAG, new FieldMetaData("tag", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.PUBLISHED_AT, new FieldMetaData("publishedAt", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.NEWS_ID, new FieldMetaData("newsId", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.TITLE, new FieldMetaData("title", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.DESCRIPTION, new FieldMetaData("description", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.IMAGE_URL, new FieldMetaData("imageUrl", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.FACULTY, new FieldMetaData("faculty", TFieldRequirementType.DEFAULT, 
        new FieldValueMetaData(TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(NewsItemByUserT.class, metaDataMap);
  }

  public NewsItemByUserT() {
  }

  public NewsItemByUserT(
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
  public NewsItemByUserT(NewsItemByUserT other) {
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

  public NewsItemByUserT deepCopy() {
    return new NewsItemByUserT(this);
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

  public NewsItemByUserT setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public void unsetUserId() {
    this.userId = null;
  }

  /** Returns true if field userId is set (has been asigned a value) and false otherwise */
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

  public NewsItemByUserT setTag(String tag) {
    this.tag = tag;
    return this;
  }

  public void unsetTag() {
    this.tag = null;
  }

  /** Returns true if field tag is set (has been asigned a value) and false otherwise */
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

  public NewsItemByUserT setPublishedAt(String publishedAt) {
    this.publishedAt = publishedAt;
    return this;
  }

  public void unsetPublishedAt() {
    this.publishedAt = null;
  }

  /** Returns true if field publishedAt is set (has been asigned a value) and false otherwise */
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

  public NewsItemByUserT setNewsId(String newsId) {
    this.newsId = newsId;
    return this;
  }

  public void unsetNewsId() {
    this.newsId = null;
  }

  /** Returns true if field newsId is set (has been asigned a value) and false otherwise */
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

  public NewsItemByUserT setTitle(String title) {
    this.title = title;
    return this;
  }

  public void unsetTitle() {
    this.title = null;
  }

  /** Returns true if field title is set (has been asigned a value) and false otherwise */
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

  public NewsItemByUserT setDescription(String description) {
    this.description = description;
    return this;
  }

  public void unsetDescription() {
    this.description = null;
  }

  /** Returns true if field description is set (has been asigned a value) and false otherwise */
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

  public NewsItemByUserT setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  public void unsetImageUrl() {
    this.imageUrl = null;
  }

  /** Returns true if field imageUrl is set (has been asigned a value) and false otherwise */
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

  public NewsItemByUserT setFaculty(String faculty) {
    this.faculty = faculty;
    return this;
  }

  public void unsetFaculty() {
    this.faculty = null;
  }

  /** Returns true if field faculty is set (has been asigned a value) and false otherwise */
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

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
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
    if (that instanceof NewsItemByUserT)
      return this.equals((NewsItemByUserT)that);
    return false;
  }

  public boolean equals(NewsItemByUserT that) {
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
    return 0;
  }

  public int compareTo(NewsItemByUserT other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    NewsItemByUserT typedOther = (NewsItemByUserT)other;

    lastComparison = Boolean.valueOf(isSetUserId()).compareTo(typedOther.isSetUserId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserId()) {
      lastComparison = TBaseHelper.compareTo(this.userId, typedOther.userId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTag()).compareTo(typedOther.isSetTag());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTag()) {
      lastComparison = TBaseHelper.compareTo(this.tag, typedOther.tag);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPublishedAt()).compareTo(typedOther.isSetPublishedAt());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPublishedAt()) {
      lastComparison = TBaseHelper.compareTo(this.publishedAt, typedOther.publishedAt);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetNewsId()).compareTo(typedOther.isSetNewsId());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNewsId()) {
      lastComparison = TBaseHelper.compareTo(this.newsId, typedOther.newsId);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetTitle()).compareTo(typedOther.isSetTitle());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTitle()) {
      lastComparison = TBaseHelper.compareTo(this.title, typedOther.title);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetDescription()).compareTo(typedOther.isSetDescription());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDescription()) {
      lastComparison = TBaseHelper.compareTo(this.description, typedOther.description);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetImageUrl()).compareTo(typedOther.isSetImageUrl());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetImageUrl()) {
      lastComparison = TBaseHelper.compareTo(this.imageUrl, typedOther.imageUrl);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFaculty()).compareTo(typedOther.isSetFaculty());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFaculty()) {
      lastComparison = TBaseHelper.compareTo(this.faculty, typedOther.faculty);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // USER_ID
          if (field.type == TType.STRING) {
            this.userId = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // TAG
          if (field.type == TType.STRING) {
            this.tag = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // PUBLISHED_AT
          if (field.type == TType.STRING) {
            this.publishedAt = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // NEWS_ID
          if (field.type == TType.STRING) {
            this.newsId = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 5: // TITLE
          if (field.type == TType.STRING) {
            this.title = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 6: // DESCRIPTION
          if (field.type == TType.STRING) {
            this.description = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 7: // IMAGE_URL
          if (field.type == TType.STRING) {
            this.imageUrl = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 8: // FACULTY
          if (field.type == TType.STRING) {
            this.faculty = iprot.readString();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.userId != null) {
      oprot.writeFieldBegin(USER_ID_FIELD_DESC);
      oprot.writeString(this.userId);
      oprot.writeFieldEnd();
    }
    if (this.tag != null) {
      oprot.writeFieldBegin(TAG_FIELD_DESC);
      oprot.writeString(this.tag);
      oprot.writeFieldEnd();
    }
    if (this.publishedAt != null) {
      oprot.writeFieldBegin(PUBLISHED_AT_FIELD_DESC);
      oprot.writeString(this.publishedAt);
      oprot.writeFieldEnd();
    }
    if (this.newsId != null) {
      oprot.writeFieldBegin(NEWS_ID_FIELD_DESC);
      oprot.writeString(this.newsId);
      oprot.writeFieldEnd();
    }
    if (this.title != null) {
      oprot.writeFieldBegin(TITLE_FIELD_DESC);
      oprot.writeString(this.title);
      oprot.writeFieldEnd();
    }
    if (this.description != null) {
      oprot.writeFieldBegin(DESCRIPTION_FIELD_DESC);
      oprot.writeString(this.description);
      oprot.writeFieldEnd();
    }
    if (this.imageUrl != null) {
      oprot.writeFieldBegin(IMAGE_URL_FIELD_DESC);
      oprot.writeString(this.imageUrl);
      oprot.writeFieldEnd();
    }
    if (this.faculty != null) {
      oprot.writeFieldBegin(FACULTY_FIELD_DESC);
      oprot.writeString(this.faculty);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("NewsItemByUserT(");
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

  public void validate() throws TException {
    // check for required fields
  }

}
