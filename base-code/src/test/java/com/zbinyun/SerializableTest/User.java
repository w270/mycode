package com.zbinyun.SerializableTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -7890663945232864573L;

    @Protobuf(fieldType = FieldType.INT32, required = false, order = 1)
    private Integer userId;

    @Protobuf(fieldType = FieldType.STRING, required = false, order = 2)
    private String userName;

    @Protobuf(fieldType = FieldType.STRING, required = false, order = 3)
    private String passWord;

    @Protobuf(fieldType = FieldType.STRING, required = false, order = 4)
    private String userInfo;

    @Protobuf(fieldType = FieldType.OBJECT, required = false, order = 5)
    private List<User> friends;

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", passWord=" + passWord + ", userInfo=" + userInfo
                + ", friends=" + friends + "]";
    }
}
