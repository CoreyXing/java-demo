# 注解使用案例

## 常用元注解

**Target**：描述了注解修饰的对象范围，取值在`java.lang.annotation.ElementType`定义，常用的包括：

- METHOD：用于描述方法
- PACKAGE：用于描述包
- PARAMETER：用于描述方法变量
- TYPE：用于描述类、接口或enum类型

**Retention**: 表示注解保留时间长短。取值在`java.lang.annotation.RetentionPolicy`中，取值为：

- SOURCE：在源文件中有效，编译过程中会被忽略
- CLASS：随源文件一起编译在class文件中，运行时忽略
- RUNTIME：在运行时有效

只有定义为`RetentionPolicy.RUNTIME`时，我们才能通过注解反射获取到注解。 所以，假设我们要自定义一个注解，它用在字段上，并且可以通过反射获取到，功能是用来描述字段的长度和作用。

## 示例

先定义一个注解

```java
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyField {
    String description();
    int length();
}
```

