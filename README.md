jersey-sample
=============

jersey sample：Authenticate by Shiro

## NOTICE

服务端如果指定了MediaType，客户端也需要指定对应的MediaType，如服务端指定了接受的Media类型为APPLICATION_JSON：
```java

@POST
@Path("/save")
@Consumes(MediaType.APPLICATION_JSON)
public String save(StudentForm form) {
	for (Student student : form.getList()) {
		System.out.println(student);
	}
	return "success";
}
```
则客户端需要同时指定类型为APPLICATION_JSON：
```java
resource.type(MediaType.APPLICATION_JSON).post(object);
```
如果客户端向服务器端post Object对象，则需要在Object对象上加入注解：@XmlRootElement
如果post的是一个Object集合，则会报错。解决方法是自己包装一个对象，加入@XmlRootElement注解，将list当作此对象中的一个普通属性来post。例：
#### 封装一个StudentForm对象
```java
package jersey.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class StudentForm {
	private List<Student> list;

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

}

```
然后可以这样post：
```
StudentForm form = new StudentForm();
form.setList(list);
String result = resource.type(MediaType.APPLICATION_JSON).post(String.class, form);
```
服务器端这样接收：
```java
@POST
@Path("/save")
@Consumes(MediaType.APPLICATION_JSON)
public String save(StudentForm form) {
	for (Student student : form.getList()) {
		System.out.println(student);
	}
	return "success";
}
```
## Client require jar
- jersey-client-1.18.jar
- jersey-core-1.18.jar
- jersey-json-1.18.jar

## Server require jar
- asm-3.1.jar
- jackson-core-asl-1.9.2
- jackson-jaxrs-1.9.2.jar
- jackson-mapper-asl-1.9.2.jar
- jackson-xc-1.9.2.jar
- jersey-bundle-1.17.1.jar
- jersey-core-1.18.jar
- jersey-server-1.18.jar
- shiro-core-1.2.2.jar
- shiro-web-1.2.2.jar
- slf4j-api-1.6.4.jar

## Thanks
My Blog: [LifeRefactor：wincn.net](http://wincn.net "LifeRefactor")

SEE: [jersey——轻量级restful framework推荐](http://wincn.net/admin/jersey-%E8%BD%BB%E9%87%8F%E7%BA%A7restful-framework%E6%8E%A8%E8%8D%90-4022)
