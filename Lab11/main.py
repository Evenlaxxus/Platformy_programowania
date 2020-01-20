import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
import seaborn as sns
from sklearn.datasets import load_boston
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression


def newMain():
    boston_dataset = load_boston()
    df = pd.DataFrame(data=boston_dataset.data, columns=boston_dataset.feature_names)
    # print(boston_dataset)
    df.insert(0, 'MEDV', boston_dataset.target)
    print(df.head(10))
    print(df.tail(10))
    print(df.info())
    print(df.describe())

    sns.distplot(df.get('MEDV'))
    # plt.show()

    # sns.heatmap(df.corr().round(decimals=2), annot=True)
    # plt.show()

    # sns.regplot(x=df.get('MEDV'), y=df.get('ZN'))
    # plt.show()

    # sns.regplot(x=df.get('MEDV'), y=df.get('TAX'))
    # plt.show()

    # sns.regplot(x=df.get('MEDV'), y=df.get('LSTAT'))
    # plt.show()

    x_matrix = df[['ZN', 'CHAS', 'RM', 'DIS', 'B']]
    y_tab = df[['MEDV']]

    x_train, x_test = train_test_split(x_matrix, test_size=0.2, random_state=45)
    y_train, y_test = train_test_split(y_tab, test_size=0.2, random_state=45)

    reg = LinearRegression().fit(x_train, y_train)

    x_train_pre = pd.DataFrame(reg.predict(x_train))
    x_test_pre = pd.DataFrame(reg.predict(x_test))

    plt.scatter(x=y_train['MEDV'], y=x_train_pre)
    plt.show()
    plt.scatter(x=y_test['MEDV'], y=x_test_pre)
    plt.show()
    print(reg.score(x_test, y_test))


if __name__ == "__main__":
    newMain()
