/****** Object:  Table [dbo].[user_details]    Script Date: 18/08/2024 12:58:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_details](
	[user_id] [varchar](50) NULL,
	[user_name] [varchar](50) NULL,
	[city] [varchar](50) NULL,
	[country] [varchar](50) NULL
) ON [PRIMARY]
GO
INSERT [dbo].[user_details] ([user_id], [user_name], [city], [country]) VALUES (N'10000', N'Sam', N'Pune', N'India')
INSERT [dbo].[user_details] ([user_id], [user_name], [city], [country]) VALUES (N'10001', N'Ram', N'Pune', N'India')
INSERT [dbo].[user_details] ([user_id], [user_name], [city], [country]) VALUES (N'10002', N'John', N'Pune', N'India')
INSERT [dbo].[user_details] ([user_id], [user_name], [city], [country]) VALUES (N'10003', N'Pravin', N'Pune', N'India')
INSERT [dbo].[user_details] ([user_id], [user_name], [city], [country]) VALUES (N'10004', N'Prem', N'Mumbai', N'India')
INSERT [dbo].[user_details] ([user_id], [user_name], [city], [country]) VALUES (N'10005', N'james', N'Bengluru', N'India')
INSERT [dbo].[user_details] ([user_id], [user_name], [city], [country]) VALUES (N'10006', N'jack', N'Sangli', N'India')
INSERT [dbo].[user_details] ([user_id], [user_name], [city], [country]) VALUES (N'10007', N'prasad', N'Sangli', N'India')
GO
