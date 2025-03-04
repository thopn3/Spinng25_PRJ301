USE [master]
GO
/****** Object:  Database [PRJ301DB]    Script Date: 2/25/2025 12:09:41 PM ******/
CREATE DATABASE [PRJ301DB]
GO
USE [PRJ301DB]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 2/25/2025 12:09:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Description] [nvarchar](150) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 2/25/2025 12:09:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NULL,
	[Price] [int] NULL,
	[Quantity] [int] NULL,
	[CategoryId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Categories] ON 

INSERT [dbo].[Categories] ([Id], [Name], [Description]) VALUES (1, N'Laptop', N'Máy tính xách tay')
INSERT [dbo].[Categories] ([Id], [Name], [Description]) VALUES (2, N'Smartphone', N'Điện thoại thông minh')
INSERT [dbo].[Categories] ([Id], [Name], [Description]) VALUES (3, N'Eletronic', N'Thiết bị điện - Điện tử')
SET IDENTITY_INSERT [dbo].[Categories] OFF
GO
SET IDENTITY_INSERT [dbo].[Products] ON 

INSERT [dbo].[Products] ([Id], [Name], [Price], [Quantity], [CategoryId]) VALUES (2, N'Macbook Pro M4', 50000000, 100, 1)
INSERT [dbo].[Products] ([Id], [Name], [Price], [Quantity], [CategoryId]) VALUES (3, N'Dell Latitude', 4800000, 50, 1)
INSERT [dbo].[Products] ([Id], [Name], [Price], [Quantity], [CategoryId]) VALUES (4, N'Iphone 16 ProMax', 35000000, 150, 2)
INSERT [dbo].[Products] ([Id], [Name], [Price], [Quantity], [CategoryId]) VALUES (5, N'LG Washing', 15500000, 200, 3)
INSERT [dbo].[Products] ([Id], [Name], [Price], [Quantity], [CategoryId]) VALUES (6, N'Samsung Ultra S25', 40000000, 10, 2)
SET IDENTITY_INSERT [dbo].[Products] OFF
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD FOREIGN KEY([CategoryId])
REFERENCES [dbo].[Categories] ([Id])
GO
USE [master]
GO
ALTER DATABASE [PRJ301DB] SET  READ_WRITE 
GO
