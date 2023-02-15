import React from "react";
import {Product, ProductModel} from "./Product";

export interface ProductListProps {
    products: Array<ProductModel>;
}

export const ProductList = (props: ProductListProps) => {
    const {products} = props;

    return (
        <div className={'product__list'}>
            {products.map((product: ProductModel) => {
                return (
                    <Product
                        key={`${product.ean}`}
                        name={`${product.name}`}
                        ean={`${product.ean}`}
                        description={`${product.description}`}
                        producer={`${product.producer}`}
                        category={`${product.category}`}
                    />
                )
            })
            }
        </div>
    )
}