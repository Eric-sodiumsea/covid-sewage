# 新冠污水监测系统 -- 需求分析

## 首页

### 系统拓扑图

> 在首页放一张系统拓扑图，用来告诉用户，我们的系统大概是如何运行的，从而使用户相信我们后续数据的真实性

![image](https://user-images.githubusercontent.com/76035116/209079259-22b3b4b0-b6ff-4f8e-a351-db4a2814c76b.png)

### 从样本到数据的一个过程

> 几张图片介绍一下

![image](https://user-images.githubusercontent.com/76035116/212831768-b0db7bc1-9969-4ba7-8520-f3629950b523.png)

![image](https://user-images.githubusercontent.com/76035116/212831801-7456bc78-dff3-470d-a258-85d89bd17bcf.png)

### 对各设备/环节的通俗介绍

> 网站需要一定信息概述来解释我们的系统是什么，干什么，怎么干。其中可能包括污水检测的目的,相关性，以及系统的工作原理，工作流程，包括对检测设备各部分的功能概述等，还有我们项目已经完成的检测结果以及一些结论，都可以很好地将我们项目的成果可视化，通俗化。

![image](https://user-images.githubusercontent.com/76035116/212844798-50c92e53-9c69-481b-a45b-9f04c1cb910b.png)

### 问题解答

> 放在首页，为用户解答常见的问题

![image](https://user-images.githubusercontent.com/76035116/212831540-8237045e-9b4f-4bfc-ab1e-9bf62406b62f.png)

![image](https://user-images.githubusercontent.com/76035116/212831549-9b489fc3-4ad6-4c2d-8953-5c412a05aec7.png)

![image](https://user-images.githubusercontent.com/76035116/212843053-c139f27a-94b6-4856-8d31-407f9eead97f.png)

![image](https://user-images.githubusercontent.com/76035116/212843069-dd663f15-3601-4b62-a772-73fd2644191e.png)

### 我们的这个项目或我们的这个网站的意义与作用

![image](https://user-images.githubusercontent.com/76035116/212831981-a6dc0805-dcf6-40ca-9acd-272c58c555d1.png)

-----

## 其他

### 在线监测的地图

> 在地图中，可以看到我们的设备在哪些地方。选择某个设备后，可以进行进入该设备的管理页面。

> 并且，在地图中，可以直观展示地区病毒浓度变化情况：将污水中病毒浓度变化直观展示出来，了解当地的疫情趋势。

![image](https://user-images.githubusercontent.com/76035116/212832959-d56450fd-bd0f-4d81-8e4c-804adc49f20b.png)

### 设备管理系统

> 在这里，可以看到该设备的详细信息，并且可以对其进行远程配置、升级，可以查看该设备对污水监测所获得的数据，还可以对通过设备的摄像头对现场情况进行实时观察并进行抓拍。

> 其中，设备的详细信息可以包括其位置、运行状态、电量等等。页面可以先这样实现，最后根据设备组设计再进行改动。

> 另外，设备应该有报警系统，若监测到周围环境有如火灾等情况，或者设备发生了损坏，那么在平台中会有实时的提醒。

![image](https://user-images.githubusercontent.com/76035116/209079532-ca617ca3-90b4-41ff-8a31-2c7bf45d949e.png)

> **查询状态**中可以开发设备**监测指标浮动**的功能，如果出现某个指标短时间内存在较大变化则在页面上显示一个非正常状态，此时可以人工抓拍观察现场环境，减少一些工作量并且避免突发事件带来的大结果误差。

> 做到完全的设备自动化可能有点困难，所以我们要保证设备稳定运行的同时还要保证数据产出的稳定性。因此可以在查询状态功能上更进一步，即监测数据浮动程度以初步判断环境突发异常变化，并实时在线上反馈设备当前状态以便人工介入调整。

### 数据总览展示

![image](https://user-images.githubusercontent.com/76035116/209086029-96ac6bea-4d34-4d7c-a027-7ff69d1e8c8f.png)

![image](https://user-images.githubusercontent.com/76035116/209086147-85e6f2b6-744c-4a3b-8e49-b12c93dff996.png)

#### 不同因素关联数据图表

> 目的是在数据总览时不仅仅罗列某单个统计总量，而通过可选择的因素关联更加直观地反映污水与感染率的相关性

![image](https://user-images.githubusercontent.com/76035116/212844472-60826b78-2bab-41b4-84c0-3f58ddbd8184.png)

> 包括新冠感染病例，地理位置与污水富集程度的关系，在图线展示的一定相关性中我们可以直观的了解不同因素之间的关系。我们当然可以关联更多因素以发现新冠污水在疫情中都产生了哪些影响。

![image](https://user-images.githubusercontent.com/76035116/212844547-92f86327-0a6e-4d74-a9fa-b3216e61d559.png)

### 数据详细展示

> 详细数据包括：污水的PH值、电导率、氨氮、总磷、CDD、浊度等等。 为污水排放是否达标提供依据。

![image](https://user-images.githubusercontent.com/76035116/209086098-1e0defc5-55a9-4933-9cac-b4f113cf9907.png)

### 分地区的数据展示

> 在地图显示上还可以通过标注数据示意该地区感染率或者进行其他因素的加入使得右侧图像更具作用

> 一个好的展示UI。左侧选择设备编号即地点，中间展示该设备获得的实验数据（可以进行放大缩小以在不同时间轴内进行数据比较），右侧展示设备大致检测范围

![image](https://user-images.githubusercontent.com/76035116/212845230-21425655-c6ab-4eec-94dc-32b99c87cc3e.png)

### 预测近期感染人数

![image](https://user-images.githubusercontent.com/76035116/212842861-37ec70b6-f061-4559-9d48-dd920eacc560.png)

### 事件部分

> 记录一些可能对污水中病毒浓度有较大影响的事件，例如要求进行吸入式疫苗的吸入，方便解释异常数据

![image](https://user-images.githubusercontent.com/76035116/212832525-9d932ff0-3dcb-455e-bd5f-1b18f9d7c66d.png)

### 病毒种类

> 当前地区流行病毒种类，及时做出对应预防措施，提高警惕。

![image](https://user-images.githubusercontent.com/76035116/212833077-2a0122fa-816f-4e40-b08c-e25f041409d8.png)

### 其他功能

> ·提供数据下载
·展示网站发布时间
·展示数据更新时间
·术语介绍
·提供联系的信息
·提供查看论文的入口

![image](https://user-images.githubusercontent.com/76035116/212843332-8bb1b2f2-c48d-43e5-a3d0-32df95f944d2.png)
