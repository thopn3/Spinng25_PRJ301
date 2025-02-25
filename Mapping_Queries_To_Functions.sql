-- Lấy ra tất cả sản phẩm có trong cửa hàng -> View all
select * from Products

-- Lấy ra sản phẩm có id do người dùng cung cấp -> View details by Id
select * from Products where Id = 3

-- Thêm mới 1 sản phẩm thuộc danh mục 2
insert into Products(Name,Price,Quantity, CategoryId) 
values('Samsung Ultra S25', 40000000, 10, 2)