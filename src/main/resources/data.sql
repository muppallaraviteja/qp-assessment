insert into item(id,name,price,inventory) values(1001, 'item1',12.56,3);
insert into item(id,name,price,inventory) values(1002, 'item2',37.6,4);
insert into item(id,name,price,inventory) values(1003, 'item3',45.78,7);
insert into item(id,name,price,inventory) values(1004, 'item4',22.56,8);
insert into item(id,name,price,inventory) values(1005, 'item5',16.8,10);
insert into item(id,name,price,inventory) values(1006, 'item6',1.6,1);
insert into item(id,name,price,inventory) values(1007, 'item7',124.45,79);
insert into item(id,name,price,inventory) values(1008, 'item8',16.8,6);
insert into item(id,name,price,inventory) values(1009, 'item9',12,76);
insert into item(id,name,price,inventory) values(1010, 'item10',120.45,79);
insert into item(id,name,price,inventory) values(1011, 'item11',120.45,0);
insert into item(id,name,price,inventory) values(1012, 'item12',0.56,0);

insert into customer(id,name,email,birthdate) values(1000, 'Ravi','ravi@email.com',CURRENT_DATE());
insert into customer(id,name,email,birthdate) values(1001, 'Sai','sai@email.com',CURRENT_DATE());
insert into customer(id,name,email,birthdate) values(1002, 'Hamsa','hamsa@email.com',CURRENT_DATE());
insert into customer(id,name,email,birthdate) values(1003, 'Prashanth','prashanth@email.com',CURRENT_DATE());

insert into orders(customer_id,order_id) values(1000,2000);
insert into orders(customer_id,order_id) values(1000,2001);
insert into orders(customer_id,order_id) values(1000,2002);

insert into orders(customer_id,order_id) values(1001,2003);
insert into orders(customer_id,order_id) values(1001,2004);

insert into orders(customer_id,order_id) values(1002,2005);

insert into order_item_request (order_id, item_id,quantity) values(2000,1001,2);
insert into order_item_request (order_id, item_id,quantity) values(2000,1002,1);
insert into order_item_request (order_id, item_id,quantity) values(2000,1003,4);
insert into order_item_request (order_id, item_id,quantity) values(2000,1004,3);

insert into order_item_request (order_id, item_id,quantity) values(2001,1007,3);
insert into order_item_request (order_id, item_id,quantity) values(2001,1008,2);

insert into order_item_request (order_id, item_id,quantity) values(2002,1009,1);

insert into order_item_request (order_id, item_id,quantity) values(2003,1011,2);
insert into order_item_request (order_id, item_id,quantity) values(2003,1012,1);

insert into order_item_request (order_id, item_id,quantity) values(2004,1007,3);

insert into order_item_request (order_id, item_id,quantity) values(2005,1008,9);

