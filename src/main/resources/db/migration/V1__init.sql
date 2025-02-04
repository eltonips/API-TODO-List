CREATE TABLE APITodoList.dbo.list (
	id int NOT NULL,
	nome varchar(50) COLLATE Latin1_General_CI_AS NULL
	
);

CREATE TABLE APITodoList.dbo.item (
	id int NOT NULL,
	nome varchar(50) COLLATE Latin1_General_CI_AS NULL,
	listitem_id int NOT NULL
	
);