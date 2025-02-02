CREATE TABLE APITodoList.dbo.category (
	category_id int NOT NULL,
	category_name varchar(50) COLLATE Latin1_General_CI_AS NULL,
	CONSTRAINT PK_category
        PRIMARY KEY NONCLUSTERED (category_id)
);

CREATE TABLE APITodoList.dbo.list (
	list_id int NOT NULL,
	list_name varchar(50) COLLATE Latin1_General_CI_AS NULL,
	category_id int NOT NULL,
	CONSTRAINT PK_list
        PRIMARY KEY NONCLUSTERED (list_id),
    CONSTRAINT FK_lists FOREIGN KEY (category_id)
        REFERENCES APITodoList.dbo.category(category_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE APITodoList.dbo.item (
	item_id int NOT NULL,
	item_name varchar(50) COLLATE Latin1_General_CI_AS NULL,
	list_id int NOT NULL,
	CONSTRAINT PK_item
        PRIMARY KEY NONCLUSTERED (item_id),
    CONSTRAINT FK_lists FOREIGN KEY (list_id)
        REFERENCES APITodoList.dbo.list(list_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

