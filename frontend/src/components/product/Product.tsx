import React from 'react';
import './Product.css';

export interface ProductModel {
    name: string;
    ean: string;
    description: string;
    producer: string;
    category: string;
}

export const Product = (props: ProductModel) => {
    const {name, ean, description, producer, category} = props;
    return (
        <div className={'product__card'}>
            <div className={'product__name'}><strong>Name: </strong>{name}</div>
            <div className={'product__ean'}><strong>EAN: </strong>{ean}</div>
            <div className={'product__description'}><strong>Description: </strong>{description}</div>
            <div className={'product__producer'}><strong>Producer: </strong>{producer}</div>
            <div className={'product__category'}><strong>Category: </strong>{category}</div>
        </div>
    );
}
